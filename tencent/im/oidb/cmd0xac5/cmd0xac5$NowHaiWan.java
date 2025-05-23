package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$NowHaiWan extends MessageMicro<cmd0xac5$NowHaiWan> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_game_icon;
    public final PBBytesField bytes_icon;
    public final PBBytesField bytes_room_title;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_status;
    public final PBUInt32Field uint32_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 58, 66}, new String[]{"bytes_title", "bytes_url", "uint32_status", "bytes_icon", "uint32_type", "bytes_cover_url", "bytes_game_icon", "bytes_room_title"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro}, cmd0xac5$NowHaiWan.class);
    }

    public cmd0xac5$NowHaiWan() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.uint32_status = PBField.initUInt32(0);
        this.bytes_icon = PBField.initBytes(byteStringMicro);
        this.uint32_type = PBField.initUInt32(0);
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
        this.bytes_game_icon = PBField.initBytes(byteStringMicro);
        this.bytes_room_title = PBField.initBytes(byteStringMicro);
    }
}
