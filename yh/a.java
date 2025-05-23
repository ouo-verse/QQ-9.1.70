package yh;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.ClientFeed;
import com.tencent.qqnt.kernel.nativeinterface.StComment;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StPicSpecUrlEntry;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import com.tencent.qqnt.kernel.nativeinterface.StReply;
import com.tencent.qqnt.kernel.nativeinterface.StUserAccountBaseMate;
import com.tencent.qqnt.kernel.nativeinterface.StUserAccountEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bJ*\u0010\u001a\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0006J,\u0010 \u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a8\u0006#"}, d2 = {"Lyh/a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ClientFeed;", "Lkotlin/collections/ArrayList;", "feeds", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "commonExt", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", h.F, "feed", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "g", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapperList", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "b", "", "url", "", "photoWidth", "photoHeight", "spec", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicSpecUrlEntry;", "d", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/StComment;", "comment", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "reply", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a */
    public static final a f450323a = new a();

    a() {
    }

    public final StCommonExt a() {
        String uid = LoginData.getInstance().getUid();
        StUserAccountEntry stUserAccountEntry = new StUserAccountEntry(uid, new StUserAccountBaseMate(uid, LoginData.getInstance().getUin()));
        StCommonExt stCommonExt = new StCommonExt();
        stCommonExt.mapUserAccount.add(stUserAccountEntry);
        return stCommonExt;
    }

    public final List<StMedia> b(List<? extends MediaWrapper> mediaWrapperList) {
        StMedia e16;
        ArrayList arrayList = new ArrayList();
        if (mediaWrapperList == null) {
            return arrayList;
        }
        int size = mediaWrapperList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MediaWrapper mediaWrapper = mediaWrapperList.get(i3);
            if (mediaWrapper.isImage()) {
                ImageInfo imageInfo = mediaWrapper.getImageInfo();
                e16 = imageInfo != null ? b.f(imageInfo) : null;
                if (e16 != null) {
                    arrayList.add(e16);
                } else {
                    RFWLog.e("GroupAlbumFeedDataConverter", RFWLog.USR, "imageInfo.convertToStMedia error,stMediaInfo is null");
                }
            } else {
                ShuoshuoVideoInfo videoInfo = mediaWrapper.getVideoInfo();
                e16 = videoInfo != null ? b.e(videoInfo) : null;
                if (e16 != null) {
                    arrayList.add(e16);
                } else {
                    RFWLog.e("GroupAlbumFeedDataConverter", RFWLog.USR, "videoInfo.convertToStMedia error,stMediaInfo is null");
                }
            }
        }
        return arrayList;
    }

    public final BusinessFeedData c(ClientFeed feed, StCommonExt commonExt) {
        BusinessFeedData J;
        Intrinsics.checkNotNullParameter(feed, "feed");
        J = b.J(feed, commonExt);
        return J;
    }

    public final StPicSpecUrlEntry d(String url, int photoWidth, int photoHeight, int spec) {
        return new StPicSpecUrlEntry(spec, new StPicUrl(url, photoWidth, photoHeight));
    }

    public final BusinessFeedData f(StFeed feed, StCommonExt commonExt, StComment comment, StReply reply) {
        BusinessFeedData K;
        Intrinsics.checkNotNullParameter(feed, "feed");
        K = b.K(feed, commonExt);
        ArrayList arrayList = new ArrayList();
        if (reply != null) {
            String str = reply.f359225id;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(reply);
            }
        }
        K.setCellCommentInfo(b.u(comment, commonExt, arrayList));
        return K;
    }

    public final BusinessFeedData g(StFeed feed, StCommonExt commonExt) {
        BusinessFeedData K;
        Intrinsics.checkNotNullParameter(feed, "feed");
        K = b.K(feed, commonExt);
        return K;
    }

    public final List<BusinessFeedData> h(ArrayList<ClientFeed> arrayList, StCommonExt stCommonExt) {
        BusinessFeedData J;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                J = b.J((ClientFeed) it.next(), stCommonExt);
                arrayList2.add(J);
            }
        }
        return arrayList2;
    }

    public static /* synthetic */ StPicSpecUrlEntry e(a aVar, String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 8) != 0) {
            i17 = CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal();
        }
        return aVar.d(str, i3, i16, i17);
    }
}
