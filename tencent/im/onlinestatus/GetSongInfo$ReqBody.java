package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetSongInfo$ReqBody extends MessageMicro<GetSongInfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_song_id", "uint32_song_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, GetSongInfo$ReqBody.class);
    public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_song_type = PBField.initUInt32(0);
}
