package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$StVideoAlbumFeedInfo extends MessageMicro<QQCircleFeedAlbum$StVideoAlbumFeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "album_title", "album_desc", "item_count", "page_views", "detail", "more_schema"}, new Object[]{0L, "", "", 0L, "", null, ""}, QQCircleFeedAlbum$StVideoAlbumFeedInfo.class);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public final PBStringField album_title = PBField.initString("");
    public final PBStringField album_desc = PBField.initString("");
    public final PBInt64Field item_count = PBField.initInt64(0);
    public final PBStringField page_views = PBField.initString("");
    public final PBRepeatMessageField<QQCircleFeedAlbum$StFeedDetail> detail = PBField.initRepeatMessage(QQCircleFeedAlbum$StFeedDetail.class);
    public final PBStringField more_schema = PBField.initString("");
}
