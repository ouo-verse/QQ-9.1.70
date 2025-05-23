package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqSongExtendedInfo extends MessageMicro<aio_media$ReqSongExtendedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"enum_aio_type", "uint64_id", "rpt_msg_song_list"}, new Object[]{1, 0L, null}, aio_media$ReqSongExtendedInfo.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<aio_media$SongExtendedReqParam> rpt_msg_song_list = PBField.initRepeatMessage(aio_media$SongExtendedReqParam.class);
}
