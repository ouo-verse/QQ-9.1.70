package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$AlbumPageData extends MessageMicro<QQCircleFeedBase$AlbumPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"album", "share_info", "subsidiary_field_desc"}, new Object[]{null, null, null}, QQCircleFeedBase$AlbumPageData.class);
    public FeedCloudMeta$FeedAlbum album = new FeedCloudMeta$FeedAlbum();
    public FeedCloudMeta$StShare share_info = new FeedCloudMeta$StShare();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> subsidiary_field_desc = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
