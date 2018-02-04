package entry;

class StringMixer {
    public String process(String s) {
        String s0 = "";
        for (int i = 0, length = s.length(); i < length; i += 2) {
            if (i + 1 < length) {
                s0 = s0 + s.charAt(i + 1) + s.charAt(i);
            } else {
                s0 = s0 + s.charAt(i);
            }
        }
        return s0;
    }
}

interface Processor {
    String name();
    String process(Object input);
}

class StringMixerAdapter implements Processor {
    StringMixer mixer;
    StringMixerAdapter(StringMixer mixer) {
        this.mixer = mixer;
    }
    public String name() {
        return "mixer adapter";
    }
    public String process(Object input) {
        return mixer.process((String)input);
    }
}

class Apply {
    public static void process(Processor processor, String s) {
        System.out.println(processor.process(s));
    }
}

class Main {
    public static void main(String[] args) {
        Apply.process(new StringMixerAdapter(new StringMixer()), "你我他她");
    }
}

