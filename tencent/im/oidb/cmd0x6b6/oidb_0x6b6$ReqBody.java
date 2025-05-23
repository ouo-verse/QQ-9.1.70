package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6b6$ReqBody extends MessageMicro<oidb_0x6b6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_user_ip;
    public final PBBytesField bytes_version;
    public oidb_0x6b6$AnonymousGroupMsg msg_anony;
    public oidb_0x6b6$ExtParam msg_ext_param;
    public oidb_0x6b6$GPSInfo msg_gps_info;
    public oidb_0x6b6$SendFlowerReq msg_send_flower;
    public oidb_0x6b6$ThrowFlowerReq msg_throw_flower;
    public oidb_0x6b6$TmpMsgToken msg_tmp_msg_token;
    public final PBUInt32Field uint32_c2c_type;
    public final PBUInt32Field uint32_client;
    public final PBUInt32Field uint32_group_type;
    public final PBUInt32Field uint32_instance_id;
    public final PBUInt32Field uint32_portal;
    public final PBUInt64Field uint64_group = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66, 74, 82, 90, 98, 104, 112}, new String[]{"uint64_group", "bytes_user_ip", "bytes_version", "uint32_portal", "uint32_client", "uint32_instance_id", "msg_ext_param", "msg_send_flower", "msg_throw_flower", "msg_tmp_msg_token", "msg_gps_info", "msg_anony", "uint32_c2c_type", "uint32_group_type"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0, 0, null, null, null, null, null, null, 0, 0}, oidb_0x6b6$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$ExtParam] */
    /* JADX WARN: Type inference failed for: r1v5, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$SendFlowerReq] */
    /* JADX WARN: Type inference failed for: r1v6, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$ThrowFlowerReq] */
    /* JADX WARN: Type inference failed for: r1v7, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$TmpMsgToken] */
    /* JADX WARN: Type inference failed for: r1v8, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$GPSInfo] */
    /* JADX WARN: Type inference failed for: r1v9, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$AnonymousGroupMsg] */
    public oidb_0x6b6$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_user_ip = PBField.initBytes(byteStringMicro);
        this.bytes_version = PBField.initBytes(byteStringMicro);
        this.uint32_portal = PBField.initUInt32(0);
        this.uint32_client = PBField.initUInt32(0);
        this.uint32_instance_id = PBField.initUInt32(0);
        this.msg_ext_param = new MessageMicro<oidb_0x6b6$ExtParam>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$ExtParam
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_login_sig", "uint32_business_id"}, new Object[]{null, 0}, oidb_0x6b6$ExtParam.class);
            public oidb_0x6b6$LoginSig msg_login_sig = new MessageMicro<oidb_0x6b6$LoginSig>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$LoginSig
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0x6b6$LoginSig.class);
                public final PBUInt32Field uint32_type = PBField.initUInt32(0);
                public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
            };
            public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
        };
        this.msg_send_flower = new MessageMicro<oidb_0x6b6$SendFlowerReq>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$SendFlowerReq
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_gift_text;
            public final PBBytesField bytes_recv_user_name;
            public final PBBytesField bytes_send_user_name;
            public final PBBytesField bytes_ticketid;
            public final PBInt32Field int32_discount_amount;
            public final PBInt32Field int32_count = PBField.initInt32(0);
            public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
            public final PBUInt32Field uint32_custom_flag = PBField.initUInt32(0);
            public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_gift_num = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 74, 82, 90, 96}, new String[]{"int32_count", "uint64_to_uin", "uint32_play_rule", "uint32_custom_flag", "uint32_product_id", "uint32_gift_id", "uint32_gift_num", "bytes_gift_text", "bytes_send_user_name", "bytes_recv_user_name", "bytes_ticketid", "int32_discount_amount"}, new Object[]{0, 0L, 0, 0, 0, 0, 0, byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2, 0}, oidb_0x6b6$SendFlowerReq.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_gift_text = PBField.initBytes(byteStringMicro2);
                this.bytes_send_user_name = PBField.initBytes(byteStringMicro2);
                this.bytes_recv_user_name = PBField.initBytes(byteStringMicro2);
                this.bytes_ticketid = PBField.initBytes(byteStringMicro2);
                this.int32_discount_amount = PBField.initInt32(0);
            }
        };
        this.msg_throw_flower = new MessageMicro<oidb_0x6b6$ThrowFlowerReq>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$ThrowFlowerReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_count", "uint32_play_rule", "uint32_product_id"}, new Object[]{0, 0, 0}, oidb_0x6b6$ThrowFlowerReq.class);
            public final PBInt32Field int32_count = PBField.initInt32(0);
            public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
            public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
        };
        this.msg_tmp_msg_token = new MessageMicro<oidb_0x6b6$TmpMsgToken>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$TmpMsgToken
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"buf", "c2c_type", "service_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x6b6$TmpMsgToken.class);
            public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field c2c_type = PBField.initUInt32(0);
            public final PBUInt32Field service_type = PBField.initUInt32(0);
        };
        this.msg_gps_info = new MessageMicro<oidb_0x6b6$GPSInfo>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$GPSInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int64_longitude", "int64_latitude", "int32_gps_type"}, new Object[]{0L, 0L, 0}, oidb_0x6b6$GPSInfo.class);
            public final PBInt64Field int64_longitude = PBField.initInt64(0);
            public final PBInt64Field int64_latitude = PBField.initInt64(0);
            public final PBInt32Field int32_gps_type = PBField.initInt32(0);
        };
        this.msg_anony = new MessageMicro<oidb_0x6b6$AnonymousGroupMsg>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$AnonymousGroupMsg
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField str_anon_id;
            public final PBBytesField str_anon_nick;
            public final PBBytesField str_rank_color;
            public final PBUInt32Field uint32_bubble_id;
            public final PBUInt32Field uint32_expire_time;
            public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
            public final PBUInt32Field uint32_head_portrait;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58}, new String[]{"uint32_flags", "str_anon_id", "str_anon_nick", "uint32_head_portrait", "uint32_expire_time", "uint32_bubble_id", "str_rank_color"}, new Object[]{0, byteStringMicro2, byteStringMicro2, 0, 0, 0, byteStringMicro2}, oidb_0x6b6$AnonymousGroupMsg.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.str_anon_id = PBField.initBytes(byteStringMicro2);
                this.str_anon_nick = PBField.initBytes(byteStringMicro2);
                this.uint32_head_portrait = PBField.initUInt32(0);
                this.uint32_expire_time = PBField.initUInt32(0);
                this.uint32_bubble_id = PBField.initUInt32(0);
                this.str_rank_color = PBField.initBytes(byteStringMicro2);
            }
        };
        this.uint32_c2c_type = PBField.initUInt32(0);
        this.uint32_group_type = PBField.initUInt32(0);
    }
}
