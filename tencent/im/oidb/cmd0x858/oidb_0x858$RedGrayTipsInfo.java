package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x858$RedGrayTipsInfo extends MessageMicro<oidb_0x858$RedGrayTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey;
    public final PBBytesField bytes_broadcast_rich_content;
    public final PBBytesField bytes_idiom;
    public final PBBytesField bytes_idiom_alpha;
    public final PBBytesField bytes_jumpurl;
    public final PBBytesField bytes_pc_body;
    public final PBBytesField bytes_receiver_rich_content;
    public final PBBytesField bytes_sender_rich_content;
    public final PBSInt32Field sint32_msgtype;
    public final PBUInt32Field uint32_hide_flag;
    public final PBUInt32Field uint32_icon;
    public final PBUInt32Field uint32_idiom_seq;
    public final PBUInt32Field uint32_lucky_flag;
    public final PBUInt32Field uint32_random;
    public final PBUInt32Field uint32_subchannel;
    public final PBUInt32Field uint32_time;
    public final PBUInt64Field uint64_lucky_uin;
    public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 122, 130, 136, 146, 154, 160}, new String[]{"opt_uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey", "sint32_msgtype", "uint32_lucky_flag", "uint32_hide_flag", "bytes_pc_body", "uint32_icon", "uint64_lucky_uin", "uint32_time", "uint32_random", "bytes_broadcast_rich_content", "bytes_idiom", "uint32_idiom_seq", "bytes_idiom_alpha", "bytes_jumpurl", "uint32_subchannel"}, new Object[]{0, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0L, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0}, oidb_0x858$RedGrayTipsInfo.class);
    }

    public oidb_0x858$RedGrayTipsInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sender_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_receiver_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_authkey = PBField.initBytes(byteStringMicro);
        this.sint32_msgtype = PBField.initSInt32(0);
        this.uint32_lucky_flag = PBField.initUInt32(0);
        this.uint32_hide_flag = PBField.initUInt32(0);
        this.bytes_pc_body = PBField.initBytes(byteStringMicro);
        this.uint32_icon = PBField.initUInt32(0);
        this.uint64_lucky_uin = PBField.initUInt64(0L);
        this.uint32_time = PBField.initUInt32(0);
        this.uint32_random = PBField.initUInt32(0);
        this.bytes_broadcast_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_idiom = PBField.initBytes(byteStringMicro);
        this.uint32_idiom_seq = PBField.initUInt32(0);
        this.bytes_idiom_alpha = PBField.initBytes(byteStringMicro);
        this.bytes_jumpurl = PBField.initBytes(byteStringMicro);
        this.uint32_subchannel = PBField.initUInt32(0);
    }
}
