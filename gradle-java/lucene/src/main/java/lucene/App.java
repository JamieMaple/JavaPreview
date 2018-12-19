package lucene;

import org.ansj.lucene7.AnsjAnalyzer;
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
        Document doc = new Document();
        doc.add(new TextField("id", id + "", Field.Store.YES));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new TextField("intro", intro, Field.Store.YES));
        doc.add(new TextField("test", test, Field.Store.YES));
        return doc;
    }
}

public class App {
    static List<Person> personList = new ArrayList();
    static Directory directory;
    static Analyzer analyzer = new AnsjAnalyzer(AnsjAnalyzer.TYPE.query_ansj);
    static IndexWriterConfig config = new IndexWriterConfig(analyzer).setOpenMode(IndexWriterConfig.OpenMode.CREATE);
    static IndexWriter writer;
    
    private static void loadData() {
        personList.add(new Person(0, "枫叶", "这里是枫叶的介绍"));
        Person p = new Person(1, "洁明", "这里是洁明的介绍");
        p.setTest("这是一个关于你自身的故事。你体内的故事——。\n" +
                  "人的细胞数量，约为37兆2千亿个。\n" +
                  "细胞们在名为身体的世界中，今天也精神满满、无休无眠地在工作着。\n" +
                  "运送着氧气的红细胞，与细菌战斗的白细胞……！这里，有着细胞们不为人知的故事。");
        personList.add(p);
        Person q = new Person(1, "测试", "这里是测试1的介绍");
        q.setTest("——真正的实力，平等究竟是什么？\n" +
                          "几乎百分之百实现升学、就业目标的全国首屈一指的名门校──高度育成高等学校。" +
                          "这间简直如同乐园般的学校，真面目却是唯有优秀者才能享受优待的实力上主义学校！" +
                          "绫小路清隆被分配到最底层的D班。" +
                          "在那里，他遇见了成绩优异个性却超难搞的美少女──堀北铃音，和由体贴与温柔所构成，天使般的少女──栉田桔梗。" +
                          "与她们的相遇，使清隆的态度逐渐改变。大人气作者组合所赠予的，全新学园默示录!?");
        personList.add(q);
        personList.add(new Person(1, "测试", "这里是测试二的介绍"));
        personList.add(new Person(1, "前缀", "前缀这里是前缀二的介绍"));
    }
    
    private static void initStore() {
        try {
            directory = FSDirectory.open(Paths.get("./data"));
            writer = new IndexWriter(directory, config);
            if (writer.numDocs() <= 0) {
                loadData();
            }
        } catch(Exception err) {
            System.err.println(err);
            return;
        }
    
        for (Person person : personList) {
            try {
                writer.addDocument(person.getDocument());
            } catch(Exception err) {
                System.err.println(err);
            }
        }
    
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
            Query query = new QueryParser(inField, analyzer).parse(queryString);
            return searchIndex(query);
        } catch (Exception err) {
            System.err.println(err);
            return null;
        }
    }
    
    private static List<Document> searchIndexWithTerm(String inField, String queryString) {
        Term term = new Term(inField, queryString);
        Query query = new TermQuery(term);
        return searchIndex(query);
    }
    
    private static List<Document> searchIndexWithPrefix(String inField, String prefix) {
        Term term = new Term(inField, prefix);
        Query query = new PrefixQuery(term);
        return searchIndex(query);
    }
    
    private static List<Document> searchIndexWithWild(String inField, String queryString) {
        Term term = new Term(inField, queryString);
        Query query = new WildcardQuery(term);
        return searchIndex(query);
    }
    
    private static List<Document> searchIndex(Query query) {
        List<Document> documents = new ArrayList<>();
        try {
            DirectoryReader reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(query, 10);
        
            for (ScoreDoc scoreDoc: docs.scoreDocs) {
                documents.add(searcher.doc(scoreDoc.doc));
            }
            reader.close();
        } catch(Exception err) {
            System.err.println(err);
            return documents;
        }
    
        return documents;
    }
    
    public static void main(String[] args) {
//        initStore();
////        List<Document> docs = searchIndexWithTerm("intro", "maple");
////        List<Document> docs = searchIndexWithQuery("intro", "的介绍");
//        List <Document> docs = searchIndexWithWild("test", "胞数");
//        for (Document doc : docs) {
//            System.out.println(doc.get("test"));
//        }
        String str = "小说改,奇幻,智斗,装逼,战斗,魔法";
        System.out.println(ToAnalysis.parse(str));
    }
}
