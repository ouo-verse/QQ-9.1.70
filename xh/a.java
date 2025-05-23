package xh;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.ActiveAlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumAccessPermission;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumOpInfo;
import com.tencent.qqnt.kernel.nativeinterface.FamilyAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.LoverAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.MemoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.ShareAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellVisitor;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.qqnt.kernel.nativeinterface.TravelAlbumMeta;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "a", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final CommonAlbumInfo a(AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "<this>");
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String str = albumInfo.albumId;
        Intrinsics.checkNotNullExpressionValue(str, "this.albumId");
        commonAlbumInfo.V(str);
        String str2 = albumInfo.owner;
        Intrinsics.checkNotNullExpressionValue(str2, "this.owner");
        commonAlbumInfo.o0(str2);
        String str3 = albumInfo.name;
        Intrinsics.checkNotNullExpressionValue(str3, "this.name");
        commonAlbumInfo.m0(str3);
        String str4 = albumInfo.desc;
        Intrinsics.checkNotNullExpressionValue(str4, "this.desc");
        commonAlbumInfo.g0(str4);
        commonAlbumInfo.d0(albumInfo.createTime);
        commonAlbumInfo.l0(albumInfo.modifyTime);
        commonAlbumInfo.i0(albumInfo.lastUploadTime);
        commonAlbumInfo.y0(albumInfo.uploadNumber);
        StMedia stMedia = albumInfo.cover;
        Intrinsics.checkNotNullExpressionValue(stMedia, "this.cover");
        commonAlbumInfo.b0(h.b(stMedia));
        StUser stUser = albumInfo.creator;
        Intrinsics.checkNotNullExpressionValue(stUser, "this.creator");
        commonAlbumInfo.e0(i.a(stUser));
        commonAlbumInfo.w0(albumInfo.topFlag);
        commonAlbumInfo.u0(albumInfo.status);
        AlbumAccessPermission albumAccessPermission = albumInfo.permission;
        Intrinsics.checkNotNullExpressionValue(albumAccessPermission, "this.permission");
        commonAlbumInfo.p0(fb.a.b(albumAccessPermission));
        commonAlbumInfo.Z(albumInfo.allowShare);
        commonAlbumInfo.v0(albumInfo.isSubscribe);
        String str5 = albumInfo.bitmap;
        Intrinsics.checkNotNullExpressionValue(str5, "this.bitmap");
        commonAlbumInfo.a0(str5);
        commonAlbumInfo.s0(albumInfo.isShareAlbum);
        commonAlbumInfo.q0(albumInfo.qzAlbumType);
        ShareAlbumMeta shareAlbumMeta = albumInfo.shareAlbum;
        Intrinsics.checkNotNullExpressionValue(shareAlbumMeta, "this.shareAlbum");
        commonAlbumInfo.r0(fb.a.n(shareAlbumMeta));
        FamilyAlbumMeta familyAlbumMeta = albumInfo.familyAlbum;
        Intrinsics.checkNotNullExpressionValue(familyAlbumMeta, "this.familyAlbum");
        commonAlbumInfo.h0(fb.a.f(familyAlbumMeta));
        LoverAlbumMeta loverAlbumMeta = albumInfo.loverAlbum;
        Intrinsics.checkNotNullExpressionValue(loverAlbumMeta, "this.loverAlbum");
        commonAlbumInfo.j0(fb.a.g(loverAlbumMeta));
        commonAlbumInfo.c0(albumInfo.coverType);
        TravelAlbumMeta travelAlbumMeta = albumInfo.travelAlbum;
        Intrinsics.checkNotNullExpressionValue(travelAlbumMeta, "this.travelAlbum");
        commonAlbumInfo.x0(fb.a.v(travelAlbumMeta));
        StFeedCellVisitor stFeedCellVisitor = albumInfo.visitorInfo;
        Intrinsics.checkNotNullExpressionValue(stFeedCellVisitor, "this.visitorInfo");
        commonAlbumInfo.z0(fb.a.r(stFeedCellVisitor));
        String str6 = albumInfo.defaultDesc;
        Intrinsics.checkNotNullExpressionValue(str6, "this.defaultDesc");
        commonAlbumInfo.f0(str6);
        AlbumOpInfo albumOpInfo = albumInfo.opInfo;
        Intrinsics.checkNotNullExpressionValue(albumOpInfo, "this.opInfo");
        commonAlbumInfo.n0(fb.a.c(albumOpInfo));
        ActiveAlbumInfo activeAlbumInfo = albumInfo.activeAlbum;
        Intrinsics.checkNotNullExpressionValue(activeAlbumInfo, "this.activeAlbum");
        commonAlbumInfo.N(fb.a.a(activeAlbumInfo));
        MemoryInfo memoryInfo = albumInfo.memoryInfo;
        Intrinsics.checkNotNullExpressionValue(memoryInfo, "this.memoryInfo");
        commonAlbumInfo.k0(fb.a.j(memoryInfo));
        commonAlbumInfo.t0(albumInfo.sortType);
        return commonAlbumInfo;
    }

    public static final AlbumInfo b(CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumInfo, "<this>");
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.albumId = commonAlbumInfo.getAlbumId();
        albumInfo.owner = commonAlbumInfo.getOwner();
        albumInfo.name = commonAlbumInfo.getName();
        albumInfo.desc = commonAlbumInfo.getDesc();
        albumInfo.modifyTime = commonAlbumInfo.getModifyTime();
        albumInfo.lastUploadTime = commonAlbumInfo.getLastUploadTime();
        albumInfo.createTime = commonAlbumInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String();
        albumInfo.uploadNumber = commonAlbumInfo.getUploadNumber();
        albumInfo.cover = h.i(commonAlbumInfo.getCover());
        albumInfo.creator = i.b(commonAlbumInfo.getCreator());
        albumInfo.topFlag = commonAlbumInfo.getTopFlag();
        albumInfo.status = commonAlbumInfo.getStatus();
        albumInfo.permission = fb.a.A(commonAlbumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String());
        albumInfo.allowShare = commonAlbumInfo.getAllowShare();
        albumInfo.isSubscribe = commonAlbumInfo.getIsSubscribe();
        albumInfo.bitmap = commonAlbumInfo.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
        albumInfo.isShareAlbum = commonAlbumInfo.getIsShareAlbum();
        albumInfo.qzAlbumType = commonAlbumInfo.getQzAlbumType();
        albumInfo.shareAlbum = fb.a.F(commonAlbumInfo.getShareAlbum());
        albumInfo.familyAlbum = fb.a.D(commonAlbumInfo.getFamilyAlbum());
        albumInfo.loverAlbum = fb.a.E(commonAlbumInfo.getLoverAlbum());
        albumInfo.travelAlbum = fb.a.J(commonAlbumInfo.getTravelAlbum());
        albumInfo.visitorInfo = fb.a.G(commonAlbumInfo.getVisitorInfo());
        albumInfo.coverType = commonAlbumInfo.getCoverType();
        albumInfo.defaultDesc = commonAlbumInfo.getDefaultDesc();
        albumInfo.opInfo = fb.a.B(commonAlbumInfo.getOpInfo());
        albumInfo.activeAlbum = fb.a.z(commonAlbumInfo.getActiveAlbumInfo());
        albumInfo.sortType = commonAlbumInfo.getSortType();
        return albumInfo;
    }
}
