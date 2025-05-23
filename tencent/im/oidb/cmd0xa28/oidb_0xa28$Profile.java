package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xa28$Profile extends MessageMicro<oidb_0xa28$Profile> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_info;
    public final PBBytesField bytes_game_level;
    public final PBBytesField bytes_game_nick;
    public final PBBytesField bytes_qq_nick;
    public final PBStringField str_bg_url;
    public final PBUInt32Field uint32_gender;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"bytes_game_nick", "bytes_qq_nick", "uint32_gender", "bytes_game_level", "bytes_common_info", "str_bg_url"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, ""}, oidb_0xa28$Profile.class);
    }

    public oidb_0xa28$Profile() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_game_nick = PBField.initBytes(byteStringMicro);
        this.bytes_qq_nick = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.bytes_game_level = PBField.initBytes(byteStringMicro);
        this.bytes_common_info = PBField.initBytes(byteStringMicro);
        this.str_bg_url = PBField.initString("");
    }
}
