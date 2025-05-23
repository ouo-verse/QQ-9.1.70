package wd;

import com.qzone.reborn.feedpro.bean.QzoneFeedProClickedComment;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b?\u0010@R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R6\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u000101j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`28\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00103\u001a\u0004\b\u001c\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b'\u0010\bR0\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b\u0018\u0010<\"\u0004\b:\u0010=\u00a8\u0006A"}, d2 = {"Lwd/d;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "commentText", "", "b", "I", "getPosition", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "position", "Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "()Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "i", "(Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;)V", "clickedComment", "d", "getRefer", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "refer", "e", "getCacheUniKey", tl.h.F, "cacheUniKey", "", "f", "Z", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "isPrivate", "g", "isRapidComment", "o", "Lcom/qzone/widget/RapidCommentExpressionInfo;", "Lcom/qzone/widget/RapidCommentExpressionInfo;", "getRcInfo", "()Lcom/qzone/widget/RapidCommentExpressionInfo;", "p", "(Lcom/qzone/widget/RapidCommentExpressionInfo;)V", "rcInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "l", "(Ljava/util/ArrayList;)V", "photoPaths", "cacheFeedKey", "", "k", "Ljava/util/Map;", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "extendInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String commentText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProClickedComment clickedComment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String refer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String cacheUniKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPrivate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isRapidComment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RapidCommentExpressionInfo rcInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> photoPaths;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String cacheFeedKey;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Map<String, String> extendInfo;

    /* renamed from: a, reason: from getter */
    public final String getCacheFeedKey() {
        return this.cacheFeedKey;
    }

    /* renamed from: b, reason: from getter */
    public final QzoneFeedProClickedComment getClickedComment() {
        return this.clickedComment;
    }

    /* renamed from: c, reason: from getter */
    public final String getCommentText() {
        return this.commentText;
    }

    public final Map<String, String> d() {
        return this.extendInfo;
    }

    public final ArrayList<String> e() {
        return this.photoPaths;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    public final void g(String str) {
        this.cacheFeedKey = str;
    }

    public final void h(String str) {
        this.cacheUniKey = str;
    }

    public final void i(QzoneFeedProClickedComment qzoneFeedProClickedComment) {
        this.clickedComment = qzoneFeedProClickedComment;
    }

    public final void j(String str) {
        this.commentText = str;
    }

    public final void k(Map<String, String> map) {
        this.extendInfo = map;
    }

    public final void l(ArrayList<String> arrayList) {
        this.photoPaths = arrayList;
    }

    public final void m(int i3) {
        this.position = i3;
    }

    public final void n(boolean z16) {
        this.isPrivate = z16;
    }

    public final void o(boolean z16) {
        this.isRapidComment = z16;
    }

    public final void p(RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        this.rcInfo = rapidCommentExpressionInfo;
    }

    public final void q(String str) {
        this.refer = str;
    }
}
