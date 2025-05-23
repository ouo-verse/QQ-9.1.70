package pw2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes19.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, LinkedList<String>> f427777a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static int f427778b = 6;

    /* renamed from: c, reason: collision with root package name */
    private static int f427779c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static final Queue<String> f427780d = new LinkedList();

    public static void a(String str, List<String> list, boolean z16) {
        n.a("AdFreshContext", "add[" + str + "][" + z16 + "]:" + list);
        if (list == null) {
            return;
        }
        HashMap<String, LinkedList<String>> hashMap = f427777a;
        synchronized (hashMap) {
            LinkedList<String> linkedList = hashMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                hashMap.put(str, linkedList);
            } else if (z16) {
                linkedList.clear();
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str2 = list.get(i3);
                if (!TextUtils.isEmpty(str2)) {
                    if (linkedList.size() >= f427779c) {
                        linkedList.poll();
                    }
                    linkedList.offer(str2);
                }
            }
        }
    }

    public static void b(List<String> list) {
        if (list == null) {
            return;
        }
        int size = list.size();
        synchronized (f427780d) {
            for (int i3 = 0; i3 < size; i3++) {
                String str = list.get(i3);
                Queue<String> queue = f427780d;
                if (!queue.contains(str)) {
                    if (queue.size() >= f427778b) {
                        queue.poll();
                    }
                    queue.offer(str);
                }
            }
        }
    }

    public static List<String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.EMPTY_LIST;
        }
        HashMap<String, LinkedList<String>> hashMap = f427777a;
        synchronized (hashMap) {
            LinkedList<String> linkedList = hashMap.get(str);
            if (y.h(linkedList)) {
                return Collections.EMPTY_LIST;
            }
            return new ArrayList(linkedList);
        }
    }

    public static ArrayList<String> d() {
        ArrayList<String> arrayList = new ArrayList<>();
        Queue<String> queue = f427780d;
        synchronized (queue) {
            arrayList.addAll(queue);
        }
        return arrayList;
    }
}
