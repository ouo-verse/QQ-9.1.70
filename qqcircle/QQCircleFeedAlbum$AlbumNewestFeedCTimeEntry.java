package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$AlbumNewestFeedCTimeEntry extends MessageMicro<QQCircleFeedAlbum$AlbumNewestFeedCTimeEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "feed_ctime"}, new Object[]{0L, 0L}, QQCircleFeedAlbum$AlbumNewestFeedCTimeEntry.class);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public final PBUInt64Field feed_ctime = PBField.initUInt64(0);
}
