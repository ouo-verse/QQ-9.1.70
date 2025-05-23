package yy;

import UserGrowth.stMsgRedDotCount;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f451381a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f451382b;

    /* renamed from: c, reason: collision with root package name */
    private String f451383c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f451384d;

    /* renamed from: e, reason: collision with root package name */
    private List<c> f451385e;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, stMsgRedDotCount> f451386f;

    public b(boolean z16, boolean z17, String str, boolean z18, List<c> list, Map<Integer, stMsgRedDotCount> map) {
        this.f451381a = z16;
        this.f451382b = z17;
        this.f451383c = str;
        this.f451384d = z18;
        this.f451385e = list;
        this.f451386f = map;
    }

    public String a() {
        return this.f451383c;
    }

    public stMsgRedDotCount b() {
        Map<Integer, stMsgRedDotCount> map = this.f451386f;
        if (map == null) {
            return null;
        }
        return map.get(4);
    }

    public stMsgRedDotCount c() {
        Map<Integer, stMsgRedDotCount> map = this.f451386f;
        if (map == null) {
            return null;
        }
        return map.get(2);
    }

    public stMsgRedDotCount d() {
        Map<Integer, stMsgRedDotCount> map = this.f451386f;
        if (map == null) {
            return null;
        }
        return map.get(5);
    }

    public List<c> e() {
        return this.f451385e;
    }

    public boolean f() {
        return this.f451384d;
    }

    public boolean g() {
        return this.f451381a;
    }

    public boolean h() {
        return this.f451382b;
    }

    public void i(boolean z16, boolean z17, String str, boolean z18) {
        this.f451381a = z16;
        this.f451382b = z17;
        this.f451383c = str;
        this.f451384d = z18;
    }
}
