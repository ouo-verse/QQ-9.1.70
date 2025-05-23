package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumInfosReq extends MessageMicro<QQCircleFeedAlbum$GetAlbumInfosReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"album_ids"}, new Object[]{0L}, QQCircleFeedAlbum$GetAlbumInfosReq.class);
    public final PBRepeatField<Long> album_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
