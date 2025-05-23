package tencent.im.oidb.qqmusic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MusicSongInfoMatch$CMsgResponse extends MessageMicro<MusicSongInfoMatch$CMsgResponse> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField data;

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f436023msg;
    public final PBUInt32Field reqtype;
    public final PBUInt64Field code = PBField.initUInt64(0);
    public final PBUInt32Field subcode = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"code", "subcode", "msg", "data", "reqtype"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro, 0}, MusicSongInfoMatch$CMsgResponse.class);
    }

    public MusicSongInfoMatch$CMsgResponse() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f436023msg = PBField.initBytes(byteStringMicro);
        this.data = PBField.initBytes(byteStringMicro);
        this.reqtype = PBField.initUInt32(0);
    }
}
