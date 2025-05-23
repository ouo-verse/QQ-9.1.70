package tencent.im.cs.cmd0xe59;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe59$RspBody extends MessageMicro<cmd0xe59$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f435937msg;
    public final PBBoolField safe_hit_flag;
    public final PBBytesField song_lyric;
    public final PBBoolField zip_compress_flag;
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBUInt32Field sub_ret = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"ret", "sub_ret", "msg", "song_lyric", "zip_compress_flag", "safe_hit_flag"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, bool, bool}, cmd0xe59$RspBody.class);
    }

    public cmd0xe59$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f435937msg = PBField.initBytes(byteStringMicro);
        this.song_lyric = PBField.initBytes(byteStringMicro);
        this.zip_compress_flag = PBField.initBool(false);
        this.safe_hit_flag = PBField.initBool(false);
    }
}
