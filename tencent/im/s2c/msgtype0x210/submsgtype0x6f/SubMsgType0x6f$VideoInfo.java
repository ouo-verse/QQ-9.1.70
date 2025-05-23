package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$VideoInfo extends MessageMicro<SubMsgType0x6f$VideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_vid;
    public final PBBytesField bytes_video_cover_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_vid", "bytes_video_cover_url"}, new Object[]{byteStringMicro, byteStringMicro}, SubMsgType0x6f$VideoInfo.class);
    }

    public SubMsgType0x6f$VideoInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_vid = PBField.initBytes(byteStringMicro);
        this.bytes_video_cover_url = PBField.initBytes(byteStringMicro);
    }
}
