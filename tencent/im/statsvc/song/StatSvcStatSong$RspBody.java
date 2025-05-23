package tencent.im.statsvc.song;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatSvcStatSong$RspBody extends MessageMicro<StatSvcStatSong$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"error_code", "error_msg", "bytes_song_id"}, new Object[]{0, "", ByteStringMicro.EMPTY}, StatSvcStatSong$RspBody.class);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
