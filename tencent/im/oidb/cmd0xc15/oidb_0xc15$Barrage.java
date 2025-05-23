package tencent.im.oidb.cmd0xc15;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc15$Barrage extends MessageMicro<oidb_0xc15$Barrage> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_barrage_id;
    public final PBBytesField bytes_comment;
    public final PBBytesField bytes_comment_corner_url;
    public oidb_0xc15$Sender rpt_sender;
    public final PBUInt32Field uint32_barrage_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"bytes_barrage_id", "rpt_sender", "bytes_comment", "bytes_comment_corner_url", "uint32_barrage_type"}, new Object[]{byteStringMicro, null, byteStringMicro, byteStringMicro, 0}, oidb_0xc15$Barrage.class);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [tencent.im.oidb.cmd0xc15.oidb_0xc15$Sender] */
    public oidb_0xc15$Barrage() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_barrage_id = PBField.initBytes(byteStringMicro);
        this.rpt_sender = new MessageMicro<oidb_0xc15$Sender>() { // from class: tencent.im.oidb.cmd0xc15.oidb_0xc15$Sender
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_avatar_icon_url;
            public final PBBytesField bytes_avatar_url;
            public final PBBytesField bytes_sender_name;
            public final PBUInt32Field uint32_is_author;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"bytes_avatar_url", "bytes_sender_name", "bytes_avatar_icon_url", "uint32_is_author"}, new Object[]{byteStringMicro2, byteStringMicro2, byteStringMicro2, 0}, oidb_0xc15$Sender.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_avatar_url = PBField.initBytes(byteStringMicro2);
                this.bytes_sender_name = PBField.initBytes(byteStringMicro2);
                this.bytes_avatar_icon_url = PBField.initBytes(byteStringMicro2);
                this.uint32_is_author = PBField.initUInt32(0);
            }
        };
        this.bytes_comment = PBField.initBytes(byteStringMicro);
        this.bytes_comment_corner_url = PBField.initBytes(byteStringMicro);
        this.uint32_barrage_type = PBField.initUInt32(0);
    }
}
