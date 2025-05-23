package tencent.im.cs.cmd0xe59;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe59$ReqBody extends MessageMicro<cmd0xe59$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField singer_name;
    public final PBBytesField song_id;
    public final PBBytesField song_name;
    public final PBBoolField zip_compress_flag;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"song_id", "zip_compress_flag", "singer_name", "song_name"}, new Object[]{byteStringMicro, Boolean.FALSE, byteStringMicro, byteStringMicro}, cmd0xe59$ReqBody.class);
    }

    public cmd0xe59$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.song_id = PBField.initBytes(byteStringMicro);
        this.zip_compress_flag = PBField.initBool(false);
        this.singer_name = PBField.initBytes(byteStringMicro);
        this.song_name = PBField.initBytes(byteStringMicro);
    }
}
