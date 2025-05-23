package rx.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int i3) {
        this.capacityHint = i3;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            Object[] objArr = new Object[this.capacityHint + 1];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = obj;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i3 = this.indexInTail;
        int i16 = this.capacityHint;
        if (i3 == i16) {
            Object[] objArr2 = new Object[i16 + 1];
            objArr2[0] = obj;
            this.tail[i16] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i3] = obj;
        this.indexInTail = i3 + 1;
        this.size++;
    }

    public int capacityHint() {
        return this.capacityHint;
    }

    public Object[] head() {
        return this.head;
    }

    public int indexInTail() {
        return this.indexInTail;
    }

    public int size() {
        return this.size;
    }

    public Object[] tail() {
        return this.tail;
    }

    List<Object> toList() {
        int i3 = this.capacityHint;
        int i16 = this.size;
        ArrayList arrayList = new ArrayList(i16 + 1);
        Object[] head = head();
        int i17 = 0;
        int i18 = 0;
        while (i17 < i16) {
            arrayList.add(head[i18]);
            i17++;
            i18++;
            if (i18 == i3) {
                head = (Object[]) head[i3];
                i18 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return toList().toString();
    }
}
