package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SyncSingSong$ReqBody extends MessageMicro<SyncSingSong$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"bytes_song_id", "uint32_song_type", "uint32_remaining_time", "bool_pause_flag", "uint32_song_play_time"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, Boolean.FALSE, 0}, SyncSingSong$ReqBody.class);
    public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_song_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remaining_time = PBField.initUInt32(0);
    public final PBBoolField bool_pause_flag = PBField.initBool(false);
    public final PBUInt32Field uint32_song_play_time = PBField.initUInt32(0);
}
