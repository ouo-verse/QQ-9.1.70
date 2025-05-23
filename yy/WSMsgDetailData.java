package yy;

import UserGrowth.stMsgRedDotCount;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016\"\u0004\b\u0017\u0010\u0018R2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\r\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lyy/a;", "", "", "toString", "", "a", "Z", "c", "()Z", "d", "(Z)V", "isFinished", "", "b", "I", "getSubjectID", "()I", "f", "(I)V", "subjectID", "LUserGrowth/stMsgRedDotCount;", "LUserGrowth/stMsgRedDotCount;", "()LUserGrowth/stMsgRedDotCount;", "e", "(LUserGrowth/stMsgRedDotCount;)V", "msgRedDotCount", "Ljava/util/ArrayList;", "Lyy/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setSectionList", "(Ljava/util/ArrayList;)V", "sectionList", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yy.a, reason: from toString */
/* loaded from: classes36.dex */
public final class WSMsgDetailData {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int subjectID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private stMsgRedDotCount msgRedDotCount;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isFinished = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<c> sectionList = new ArrayList<>();

    /* renamed from: a, reason: from getter */
    public final stMsgRedDotCount getMsgRedDotCount() {
        return this.msgRedDotCount;
    }

    public final ArrayList<c> b() {
        return this.sectionList;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    public final void d(boolean z16) {
        this.isFinished = z16;
    }

    public final void e(stMsgRedDotCount stmsgreddotcount) {
        this.msgRedDotCount = stmsgreddotcount;
    }

    public final void f(int i3) {
        this.subjectID = i3;
    }

    public String toString() {
        return "WSMsgDetailData(\nisFinished=" + this.isFinished + ", \nsubjectID=" + this.subjectID + ", \nmsgRedDotCount=" + this.msgRedDotCount + ", \nsectionList=" + this.sectionList + ")";
    }
}
