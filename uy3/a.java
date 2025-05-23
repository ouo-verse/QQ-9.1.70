package uy3;

import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f440613a;

    /* renamed from: c, reason: collision with root package name */
    public int f440615c;

    /* renamed from: b, reason: collision with root package name */
    public boolean f440614b = true;

    /* renamed from: d, reason: collision with root package name */
    public int f440616d = 4;

    /* renamed from: e, reason: collision with root package name */
    public SparseArray<C11377a> f440617e = new SparseArray<>(3);

    /* compiled from: P */
    /* renamed from: uy3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C11377a {

        /* renamed from: a, reason: collision with root package name */
        public int f440618a;

        /* renamed from: b, reason: collision with root package name */
        public int f440619b;

        /* renamed from: c, reason: collision with root package name */
        public float f440620c;

        /* renamed from: d, reason: collision with root package name */
        public float f440621d;

        public C11377a(int i3, int i16, float f16, float f17) {
            this.f440618a = i3;
            this.f440619b = i16;
            this.f440620c = f16;
            this.f440621d = f17;
        }

        public String toString() {
            return "MemoryLevelInfo{MemoryPercent=" + this.f440618a + ", delayTime=" + this.f440619b + ", maxCacheSize=" + this.f440620c + ", trimPercent=" + this.f440621d + '}';
        }
    }

    public a(String str) {
        this.f440613a = str;
    }

    public String toString() {
        return "ClearMemoryConfig{DpcConfigId='" + this.f440613a + "', isClearEnable=" + this.f440614b + ", delay=" + this.f440615c + ", clearStep=" + this.f440616d + ", clearLevels=" + this.f440617e + '}';
    }
}
