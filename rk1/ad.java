package rk1;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ad extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "selectGuild";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.showGuildHashtag();
        return true;
    }
}
