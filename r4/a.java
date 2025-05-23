package r4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<c> f430682a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<Integer> f430683b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Integer> f430684c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public HashMap<Integer, c> f430685d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<c> f430686e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public int f430687f = 0;

    private void f() {
        ArrayList<c> arrayList = this.f430682a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        int i3 = 0;
        for (int i16 = 0; i16 < this.f430682a.size(); i16++) {
            c cVar = this.f430682a.get(i16);
            if (cVar.f()) {
                for (int i17 = 0; i17 < cVar.e(); i17++) {
                    arrayList2.add(Integer.valueOf(i16));
                }
                arrayList3.add(Integer.valueOf(i3));
                i3 += cVar.e();
            }
        }
        this.f430687f = i3;
        this.f430683b = arrayList2;
        this.f430684c = arrayList3;
    }

    public boolean b(int i3) {
        HashMap<Integer, c> hashMap;
        c cVar;
        c d16 = d(i3);
        if (d16 == null || d16.f430703f) {
            return false;
        }
        d16.c();
        int i16 = d16.f430708k;
        if (i16 != -1 && (hashMap = this.f430685d) != null && (cVar = hashMap.get(Integer.valueOf(i16))) != null) {
            cVar.f430706i = true;
            cVar.f430703f = true;
        }
        f();
        return true;
    }

    public b c(int i3) {
        c d16 = d(i3);
        if (d16 == null) {
            return null;
        }
        ArrayList<b> d17 = d16.d();
        ArrayList<Integer> arrayList = this.f430683b;
        if (arrayList != null && i3 < arrayList.size()) {
            int intValue = this.f430683b.get(i3).intValue();
            ArrayList<Integer> arrayList2 = this.f430684c;
            if (arrayList2 != null && intValue < arrayList2.size()) {
                int intValue2 = i3 - this.f430684c.get(intValue).intValue();
                if (d17 != null && intValue2 < d17.size()) {
                    return d17.get(intValue2);
                }
            }
        }
        return null;
    }

    public c d(int i3) {
        ArrayList<c> arrayList;
        ArrayList<Integer> arrayList2;
        int intValue;
        ArrayList<Integer> arrayList3 = this.f430683b;
        if (arrayList3 == null || arrayList3.isEmpty() || (arrayList = this.f430682a) == null || arrayList.isEmpty() || (arrayList2 = this.f430684c) == null || arrayList2.isEmpty() || i3 >= this.f430687f || i3 >= this.f430683b.size() || (intValue = this.f430683b.get(i3).intValue()) >= this.f430682a.size() || intValue >= this.f430684c.size()) {
            return null;
        }
        return this.f430682a.get(intValue);
    }

    public boolean e(int i3) {
        HashMap<Integer, c> hashMap;
        c cVar;
        c d16 = d(i3);
        if (d16 == null || !d16.f430703f) {
            return false;
        }
        d16.g();
        int i16 = d16.f430708k;
        if (i16 != -1 && (hashMap = this.f430685d) != null && (cVar = hashMap.get(Integer.valueOf(i16))) != null) {
            cVar.f430706i = false;
            cVar.f430703f = false;
        }
        f();
        return true;
    }

    public void a(List<c> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f430686e.clear();
        for (c cVar : list) {
            if (cVar.f()) {
                if (cVar.f430705h) {
                    this.f430686e.add(cVar);
                }
                this.f430682a.add(cVar);
                this.f430685d.put(Integer.valueOf(cVar.f430698a), cVar);
            }
        }
        Iterator<c> it = this.f430686e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            c cVar2 = this.f430685d.get(Integer.valueOf(next.f430707j));
            next.f430706i = cVar2 == null ? false : cVar2.f430706i;
        }
        f();
    }
}
