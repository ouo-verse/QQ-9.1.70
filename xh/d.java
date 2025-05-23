package xh;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.RichMsgType;
import com.tencent.qqnt.kernel.nativeinterface.StComment;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellCommon;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellMedia;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellQunInfo;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.StImage;
import com.tencent.qqnt.kernel.nativeinterface.StLike;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StPicSpecUrlEntry;
import com.tencent.qqnt.kernel.nativeinterface.StReply;
import com.tencent.qqnt.kernel.nativeinterface.StRichMsg;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.qqnt.kernel.nativeinterface.StarInfo;
import com.tencent.qqnt.kernel.nativeinterface.YellowInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b\u001a\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\n\u001a\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f\u001a\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u00132\u0006\u0010\u0012\u001a\u00020\u0004\u001a\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001a(\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\nj\b\u0012\u0004\u0012\u00020\u0017`\u00132\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0002\u001a*\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!H\u0002\u001a \u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020!\u001a\u0018\u0010)\u001a\u00020(2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002\u00a8\u0006*"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/User;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/qqnt/kernel/nativeinterface/StUser;", "g", "", "str", "Lcom/tencent/qqnt/kernel/nativeinterface/StRichMsg;", "o", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Ljava/util/ArrayList;", "c", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "commentPictureItems", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "i", "pictureItem", tl.h.F, "content", "Lkotlin/collections/ArrayList;", "f", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "commonReply", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "e", "", "commonReplys", "d", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "spaceId", "", "actionType", "", "singlePic", "Lcom/tencent/qqnt/kernel/nativeinterface/StLike;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSinglePic", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/StComment;", "j", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {
    public static final ArrayList<StRichMsg> c(Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        ArrayList<StRichMsg> arrayList = new ArrayList<>();
        StRichMsg stRichMsg = new StRichMsg();
        stRichMsg.content = comment.comment;
        stRichMsg.type = RichMsgType.KRICHMSGTYPEPLAINTEXT.ordinal();
        arrayList.add(stRichMsg);
        ArrayList<PictureItem> arrayList2 = comment.commentPictureItems;
        if (!(arrayList2 == null || arrayList2.isEmpty())) {
            StRichMsg stRichMsg2 = new StRichMsg();
            ArrayList<PictureItem> arrayList3 = comment.commentPictureItems;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "comment.commentPictureItems");
            stRichMsg2.mediaItems = i(arrayList3);
            stRichMsg2.type = RichMsgType.KRICHMSGTYPEMEDIA.ordinal();
            arrayList.add(stRichMsg2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StReply e(Reply reply) {
        User user = reply.user;
        Intrinsics.checkNotNullExpressionValue(user, "commonReply.user");
        StUser g16 = g(user);
        User user2 = reply.targetUser;
        Intrinsics.checkNotNullExpressionValue(user2, "commonReply.targetUser");
        StUser g17 = g(user2);
        String str = reply.clientKey;
        String str2 = reply.replyId;
        long j3 = reply.date;
        String str3 = reply.content;
        Intrinsics.checkNotNullExpressionValue(str3, "commonReply.content");
        return new StReply(str2, g16, f(str3), j3, str, g17);
    }

    public static final ArrayList<StRichMsg> f(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList<StRichMsg> arrayList = new ArrayList<>();
        if (content.length() > 0) {
            arrayList.add(o(content));
        }
        return arrayList;
    }

    public static final StMedia h(PictureItem pictureItem) {
        Intrinsics.checkNotNullParameter(pictureItem, "pictureItem");
        StMedia stMedia = new StMedia();
        stMedia.type = pictureItem.type;
        stMedia.uploadTime = pictureItem.uploadTime;
        stMedia.uploader = pictureItem.uploadUid;
        StImage stImage = stMedia.image;
        StPicSpecUrlEntry stPicSpecUrlEntry = new StPicSpecUrlEntry();
        stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECCURRENT.ordinal();
        stPicSpecUrlEntry.url.url = pictureItem.currentUrl.url;
        stImage.photoUrl.add(stPicSpecUrlEntry);
        return stMedia;
    }

    public static final ArrayList<StMedia> i(ArrayList<PictureItem> commentPictureItems) {
        Intrinsics.checkNotNullParameter(commentPictureItems, "commentPictureItems");
        if (commentPictureItems.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<StMedia> arrayList = new ArrayList<>();
        Iterator<T> it = commentPictureItems.iterator();
        while (it.hasNext()) {
            arrayList.add(h((PictureItem) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StComment j(Comment comment, int i3) {
        String str = comment.commentid;
        User user = comment.user;
        Intrinsics.checkNotNullExpressionValue(user, "comment.user");
        return new StComment(str, g(user), c(comment), comment.time, d(comment.replies), comment.replyNum, comment.clientKey, new ArrayList());
    }

    public static final StFeed k(BusinessFeedData feedData, String spaceId, boolean z16) {
        String str;
        String str2;
        long j3;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        StFeed stFeed = new StFeed();
        CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
        stFeed.cellCommon = new StFeedCellCommon(cellFeedCommInfo.appid, cellFeedCommInfo.subid, cellFeedCommInfo.time / 1000, cellFeedCommInfo.feedsid, cellFeedCommInfo.curlikekey, cellFeedCommInfo.bizId, cellFeedCommInfo.clientkey, new ArrayList());
        stFeed.cellQunInfo = new StFeedCellQunInfo(spaceId);
        User user = feedData.cellUserInfo.user;
        Intrinsics.checkNotNullExpressionValue(user, "feedData.cellUserInfo.user");
        stFeed.cellUserInfo = new StFeedCellUserInfo(g(user));
        StMedia stMedia = new StMedia();
        if (feedData.getVideoInfo() != null && !TextUtils.isEmpty(feedData.getVideoInfo().albumid)) {
            str = feedData.getVideoInfo().albumid;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.videoInfo.albumid");
            j3 = feedData.getVideoInfo().batchId;
            String str3 = feedData.getVideoInfo().lloc;
            Intrinsics.checkNotNullExpressionValue(str3, "feedData.videoInfo.lloc");
            stMedia.type = 1;
            stMedia.video.cover.lloc = str3;
        } else {
            str = feedData.cellPictureInfo.albumid;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.cellPictureInfo.albumid");
            CellPictureInfo cellPictureInfo = feedData.cellPictureInfo;
            long j16 = cellPictureInfo.batchId;
            if (cellPictureInfo.pics.isEmpty()) {
                str2 = "";
            } else {
                str2 = feedData.cellPictureInfo.pics.get(0).lloc;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            feedData.c\u2026fo.pics[0].lloc\n        }");
            }
            stMedia.type = 0;
            stMedia.image.lloc = str2;
            j3 = j16;
        }
        StFeedCellMedia stFeedCellMedia = stFeed.cellMedia;
        stFeedCellMedia.albumId = str;
        stFeedCellMedia.batchId = j3;
        if (z16) {
            stFeedCellMedia.mediaItems.add(stMedia);
        }
        return stFeed;
    }

    public static final StRichMsg o(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return new StRichMsg(0, str, "", "", 0, "", "", new ArrayList());
    }

    private static final ArrayList<StReply> d(List<? extends Reply> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<StReply> arrayList = new ArrayList<>();
        Iterator<? extends Reply> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e(it.next()));
        }
        return arrayList;
    }

    private static final StUser g(User user) {
        return new StUser(user.uid.toString(), user.nickName, new YellowInfo(), new StarInfo(), false, false, false, "", "", "", 0, 0, String.valueOf(user.uin), "");
    }

    public static /* synthetic */ StFeed l(BusinessFeedData businessFeedData, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return k(businessFeedData, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ StLike n(BusinessFeedData businessFeedData, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        return m(businessFeedData, str, i3, z16);
    }

    private static final StLike m(BusinessFeedData businessFeedData, String str, int i3, boolean z16) {
        return new StLike(businessFeedData.cellLikeInfo.likeKey, i3, i3, new StUser(LoginData.getInstance().getUid(), LoginData.getInstance().getNickName(""), new YellowInfo(), new StarInfo(), false, false, false, "", "", "", 0, 0, String.valueOf(LoginData.getInstance().getUin()), ""), i3 == 0 ? 1 : 2);
    }
}
