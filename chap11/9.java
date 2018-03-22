package innerclasses.controller;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

class Controller {
    private List<Event> eventList = new LinkedList<Event>();
    public void addEvent(Event e) {
        eventList.add(e);
    }
    public void run() {
        LinkedList<Event> events = new LinkedList<Event>(eventList);
        Iterator<Event> it = events.iterator();
        while (it.hasNext()) {
            Event e = it.next();
            if (e.ready()) {
                System.out.println(e);
                e.action();
                eventList.remove(e);
            }
        }
    }
}

