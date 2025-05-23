package tencent.im.oidb.qqmusic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class MusicSongInfoMatch$ParamPair extends MessageMicro<MusicSongInfoMatch$ParamPair> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField key;
    public final PBBytesField value;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{byteStringMicro, byteStringMicro}, MusicSongInfoMatch$ParamPair.class);
    }

    public MusicSongInfoMatch$ParamPair() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key = PBField.initBytes(byteStringMicro);
        this.value = PBField.initBytes(byteStringMicro);
    }
}
