package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$FeedItem extends MessageMicro<QQCircleFeedAlbum$FeedItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "feed_sign", "order", "serial_number"}, new Object[]{0L, null, 0L, 0}, QQCircleFeedAlbum$FeedItem.class);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public QQCircleFeedAlbum$FeedSign feed_sign = new QQCircleFeedAlbum$FeedSign();
    public final PBInt64Field order = PBField.initInt64(0);
    public final PBUInt32Field serial_number = PBField.initUInt32(0);
}
