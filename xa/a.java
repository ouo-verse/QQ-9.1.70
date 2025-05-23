package xa;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareAlbumMeta;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b>\u0010?R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0003\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0019\u0010#\"\u0004\b$\u0010%R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010(\u001a\u0004\b!\u0010)\"\u0004\b*\u0010+R(\u00100\u001a\b\u0012\u0004\u0012\u00020-0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010(\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R$\u00106\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u00102\u001a\u0004\b\u0013\u00103\"\u0004\b4\u00105R\"\u0010=\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lxa/a;", "", "", "a", "I", "e", "()I", "pageId", "", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "uin", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "albumId", "d", DomainData.DOMAIN_NAME, AEEditorConstants.ALBUMNAME, "o", "creatorUin", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", h.F, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "r", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;)V", "shareAlbumMeta", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", "g", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;)V", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "Ljava/util/List;", "()Ljava/util/List;", "setRightList", "(Ljava/util/List;)V", "rightList", "Lxa/d;", "j", "setUinInfos", "uinInfos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "p", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;)V", "mediaLbsAreaList", "", "k", "Z", "()Z", "l", "(Z)V", "isAlbumDetailEmpty", "<init>", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int pageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String creatorUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonShareAlbumMeta shareAlbumMeta;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumAccessPermission permission;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<Integer> rightList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<d> uinInfos;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private CommonMediaLbsAreaList mediaLbsAreaList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isAlbumDetailEmpty;

    public a() {
        this(0, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final String getCreatorUin() {
        return this.creatorUin;
    }

    /* renamed from: d, reason: from getter */
    public final CommonMediaLbsAreaList getMediaLbsAreaList() {
        return this.mediaLbsAreaList;
    }

    /* renamed from: e, reason: from getter */
    public final int getPageId() {
        return this.pageId;
    }

    /* renamed from: f, reason: from getter */
    public final CommonAlbumAccessPermission getPermission() {
        return this.permission;
    }

    public final List<Integer> g() {
        return this.rightList;
    }

    /* renamed from: h, reason: from getter */
    public final CommonShareAlbumMeta getShareAlbumMeta() {
        return this.shareAlbumMeta;
    }

    /* renamed from: i, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final List<d> j() {
        return this.uinInfos;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsAlbumDetailEmpty() {
        return this.isAlbumDetailEmpty;
    }

    public final void l(boolean z16) {
        this.isAlbumDetailEmpty = z16;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creatorUin = str;
    }

    public final void p(CommonMediaLbsAreaList commonMediaLbsAreaList) {
        this.mediaLbsAreaList = commonMediaLbsAreaList;
    }

    public final void q(CommonAlbumAccessPermission commonAlbumAccessPermission) {
        Intrinsics.checkNotNullParameter(commonAlbumAccessPermission, "<set-?>");
        this.permission = commonAlbumAccessPermission;
    }

    public final void r(CommonShareAlbumMeta commonShareAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonShareAlbumMeta, "<set-?>");
        this.shareAlbumMeta = commonShareAlbumMeta;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public a(int i3) {
        this.pageId = i3;
        this.uin = "";
        this.albumId = "";
        this.albumName = "";
        this.creatorUin = "";
        this.shareAlbumMeta = new CommonShareAlbumMeta();
        this.permission = new CommonAlbumAccessPermission();
        this.rightList = new ArrayList();
        this.uinInfos = new ArrayList();
    }

    public /* synthetic */ a(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3);
    }
}
