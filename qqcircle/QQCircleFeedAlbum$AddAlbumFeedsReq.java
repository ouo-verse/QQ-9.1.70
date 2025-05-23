package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$AddAlbumFeedsReq extends MessageMicro<QQCircleFeedAlbum$AddAlbumFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"add_type", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "feed_signs"}, new Object[]{0, 0L, null}, QQCircleFeedAlbum$AddAlbumFeedsReq.class);
    public final PBEnumField add_type = PBField.initEnum(0);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<QQCircleFeedAlbum$FeedSign> feed_signs = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedSign.class);
}
