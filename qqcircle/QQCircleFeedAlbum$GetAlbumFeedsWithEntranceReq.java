package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumFeedsWithEntranceReq extends MessageMicro<QQCircleFeedAlbum$GetAlbumFeedsWithEntranceReq> {
    public static final int FEED = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "count", "entrance_type", "entrance_feed"}, new Object[]{0L, 0, 0, null}, QQCircleFeedAlbum$GetAlbumFeedsWithEntranceReq.class);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBEnumField entrance_type = PBField.initEnum(0);
    public QQCircleFeedAlbum$FeedSign entrance_feed = new QQCircleFeedAlbum$FeedSign();
}
