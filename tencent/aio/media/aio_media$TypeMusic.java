package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$TypeMusic extends MessageMicro<aio_media$TypeMusic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"rpt_msg_song_list", "uint32_progress_seek", "int32_progress_seek", "enum_play_mode", "bool_allow_member_start", "bool_allow_member_add"}, new Object[]{null, 0, 0, 1, Boolean.TRUE, Boolean.FALSE}, aio_media$TypeMusic.class);
    public final PBRepeatMessageField<aio_media$Song> rpt_msg_song_list = PBField.initRepeatMessage(aio_media$Song.class);
    public final PBUInt32Field uint32_progress_seek = PBField.initUInt32(0);
    public final PBInt32Field int32_progress_seek = PBField.initInt32(0);
    public final PBEnumField enum_play_mode = PBField.initEnum(1);
    public final PBBoolField bool_allow_member_start = PBField.initBool(true);
    public final PBBoolField bool_allow_member_add = PBField.initBool(false);
}
