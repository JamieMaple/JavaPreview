package lucene;

import org.ansj.lucene7.AnsjAnalyzer;
import org.ansj.recognition.impl.SynonymsRecgnition;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.document.Document;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    public int id;

    public String name;

    public String intro;
    
    public String test;
    
    public Person(int id, String name, String intro) {
        this.id = id;
        this.name = name;
        this.intro = intro;
    }
    
    public void setTest(String test) {
        this.test = test;
    }
    
    public Document getDocument() {
        var doc = new Document();
        doc.add(new TextField("id", id + "", Field.Store.YES));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new TextField("intro", intro, Field.Store.YES));
        doc.add(new TextField("test", test, Field.Store.YES));
        return doc;
    }
}

public class App {
    static List<Person> personList = new ArrayList<>();
    static Directory directory;
    static Analyzer analyzer = new AnsjAnalyzer(AnsjAnalyzer.TYPE.dic_ansj);
    static IndexWriterConfig config = new IndexWriterConfig(analyzer).setOpenMode(IndexWriterConfig.OpenMode.CREATE);
    static IndexWriter writer;
    
    private static void loadData() {
        personList.add(new Person(0, "枫叶", "这里是枫叶的介绍"));
        var p = new Person(1, "洁明", "这里是洁明的介绍");
        p.setTest("这是一个关于你自身的故事。你体内的故事——。\n" +
                  "人的细胞数量，约为37兆2千亿个。\n" +
                  "细胞们在名为身体的世界中，今天也精神满满、无休无眠地在工作着。\n" +
                  "运送着氧气的红细胞，与细菌战斗的白细胞……！这里，有着细胞们不为人知的故事。");
        personList.add(p);
        var q = new Person(1, "测试", "这里是测试1的介绍");
        q.setTest("——真正的实力，平等究竟是什么？\n" +
                          "几乎百分之百实现升学、就业目标的全国首屈一指的名门校──高度育成高等学校。" +
                          "这间简直如同乐园般的学校，真面目却是唯有优秀者才能享受优待的实力上主义学校！" +
                          "绫小路清隆被分配到最底层的D班。" +
                          "在那里，他遇见了成绩优异个性却超难搞的美少女──堀北铃音，和由体贴与温柔所构成，天使般的少女──栉田桔梗。" +
                          "与她们的相遇，使清隆的态度逐渐改变。大人气作者组合所赠予的，全新学园默示录!?");
        personList.add(q);
        var r = new Person(2, "测试", "test");
        r.test = "红细胞：花泽香菜\n" +
                 "白细胞（中性粒细胞）：前野智昭\n" +
                 "杀伤性T细胞：小野大辅\n" +
                 "巨噬细胞：井上喜久子\n" +
                 "血小板：长绳麻理亚\n" +
                 "辅助性T细胞：樱井孝宏\n" +
                 "调节性T细胞：早见沙织\n" +
                 "树突状细胞：冈本信彦\n" +
                 "嗜酸性粒细胞：M·A·O\n" +
                 "记忆细胞：中村悠一\n" +
                 "肥大细胞：川澄绫子\n" +
                 "前辈红血球：远藤绫\n" +
                 "肺炎球菌：吉野裕行";
        personList.add(r);
    }
    
    private static void initStore() {
        try {
            directory = FSDirectory.open(Paths.get("./data"));
            writer = new IndexWriter(directory, config);
            System.out.println(writer.numDocs());
            if (writer.numDocs() <= 0) {
                loadData();
            }
        } catch(Exception err) {
            System.err.println(err);
            return;
        }
        
        personList.forEach(p -> {
            try {
                writer.addDocument(p.getDocument());
            } catch(Exception err) {
                System.out.println(err);
            }
        });
        
        try {
            writer.commit();
            writer.flush();
            writer.close();
        } catch(Exception err) {
            System.err.println(err);
        }
    }
    
    private static List<Document> searchIndexWithQuery(String inField, String queryString) {
        try {
            var query = new QueryParser(inField, analyzer).parse(queryString);
            return searchIndex(query);
        } catch (Exception err) {
            System.err.println(err);
            return null;
        }
    }
    
    private static List<Document> searchIndexWithTerm(String inField, String queryString) {
        var term = new Term(inField, queryString);
        var query = new TermQuery(term);
        return searchIndex(query);
    }
    
    private static List<Document> searchIndexWithPrefix(String inField, String prefix) {
        var term = new Term(inField, prefix);
        var query = new PrefixQuery(term);
        return searchIndex(query);
    }
    
    private static List<Document> searchIndexWithWild(String inField, String queryString) {
        var term = new Term(inField, queryString);
        var query = new WildcardQuery(term);
        return searchIndex(query);
    }
    
    
    private static List<Document> searchIndexWithBoolean(String inField, String queryString) {
        var queryStringGroup = queryString.trim().split(" ");
        var builder = new  BooleanQuery.Builder();
        for (String word : queryStringGroup) {
            var term = new Term(inField, word);
            var query = new TermQuery(term);
            builder.add(query, BooleanClause.Occur.SHOULD);
        }
        return searchIndex(builder.build());
    }
    
    private static List<Document> searchIndex(Query query) {
        var documents = new ArrayList<Document>();
        try (var reader = DirectoryReader.open(writer)){
            var searcher = new IndexSearcher(reader);
            var docs = searcher.search(query, 10);
    
            Arrays.stream(docs.scoreDocs).forEach(scoreDoc -> {
                try {
                    documents.add(searcher.doc(scoreDoc.doc));
                } catch (Exception err) { }
            });
        } catch(Exception err) {
            System.err.println(err);
            return documents;
        }
    
        return documents;
    }
    
    public static void main(String[] args) {
        initStore();
//        List<Document> docs = searchIndexWithTerm("intro", "maple");
//        List<Document> docs = searchIndexWithQuery("intro", "的介绍");
        
//        String queryString = "红细胞：花泽香菜\n" +
//                             "白细胞（中性粒细胞）：前野智昭\n" +
//                             "杀伤性T细胞：小野大辅\n" +
//                             "巨噬细胞：井上喜久子\n" +
//                             "血小板：长绳麻理亚\n" +
//                             "辅助性T细胞：樱井孝宏\n" +
//                             "调节性T细胞：早见沙织\n" +
//                             "树突状细胞：冈本信彦\n" +
//                             "嗜酸性粒细胞：M·A·O\n" +
//                             "记忆细胞：中村悠一\n" +
//                             "肥大细胞：川澄绫子\n" +
//                             "前辈红血球：远藤绫\n" +
//                             "肺炎球菌：吉野裕行";
//
//        // 自定义词典
//
//        // 关联词
        var synonyms = new SynonymsRecgnition();
        
        var queryString = "花泽香菜";
        
        var result = ToAnalysis.parse(queryString).recognition(synonyms);
        var docs = searchIndexWithBoolean("test", result.toStringWithOutNature(" "));
//        docs.forEach(doc -> {
//            System.out.println(doc.get("test") + "\n");
//        });
//        docs.forEach(System.out::println);
    }
}
