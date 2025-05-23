package tencent.im.cs.cmd0x352;

import com.tencent.luggage.wxa.ig.l;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x352$TryUpImgRsp extends MessageMicro<cmd0x352$TryUpImgRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exit;
    public final PBBytesField bytes_big_down_para;
    public final PBBytesField bytes_big_thumb_down_para;
    public final PBBytesField bytes_client_ip6;
    public final PBBytesField bytes_down_domain;
    public final PBBytesField bytes_encrypt_dstip;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_original_down_para;
    public final PBBytesField bytes_thumb_down_para;
    public final PBBytesField bytes_up_resid;
    public final PBBytesField bytes_up_ukey;
    public final PBBytesField bytes_up_uuid;
    public cmd0x352$ImgInfo msg_img_info;
    public cmd0x352$TryUpInfo4Busi msg_info4busi;
    public final PBRepeatMessageField<cmd0x352$IPv6Info> rpt_msg_up_ip6;
    public final PBRepeatField<Integer> rpt_uint32_up_ip;
    public final PBRepeatField<Integer> rpt_uint32_up_port;
    public final PBUInt32Field uint32_https_url_flag;
    public final PBUInt32Field uint32_roamdays;
    public final PBUInt64Field uint64_block_size;
    public final PBUInt64Field uint64_up_offset;
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 64, 74, 82, 90, 96, 104, 114, 120, 210, 218, 482, P2VGlobalConfig.WATER_MARKER_WIDTH, l.CTRL_INDEX, 514, 522, 528, 8010}, new String[]{"uint64_file_id", "uint32_client_ip", "uint32_result", "bytes_fail_msg", "bool_file_exit", "msg_img_info", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "bytes_up_resid", "bytes_up_uuid", "uint64_up_offset", "uint64_block_size", "bytes_encrypt_dstip", "uint32_roamdays", "rpt_msg_up_ip6", "bytes_client_ip6", "bytes_thumb_down_para", "bytes_original_down_para", "bytes_down_domain", "bytes_big_down_para", "bytes_big_thumb_down_para", "uint32_https_url_flag", "msg_info4busi"}, new Object[]{0L, 0, 0, byteStringMicro, Boolean.FALSE, null, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, byteStringMicro, 0, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, null}, cmd0x352$TryUpImgRsp.class);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [tencent.im.cs.cmd0x352.cmd0x352$TryUpInfo4Busi] */
    public cmd0x352$TryUpImgRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.bool_file_exit = PBField.initBool(false);
        this.msg_img_info = new cmd0x352$ImgInfo();
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_up_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_up_port = PBField.initRepeat(pBUInt32Field);
        this.bytes_up_ukey = PBField.initBytes(byteStringMicro);
        this.bytes_up_resid = PBField.initBytes(byteStringMicro);
        this.bytes_up_uuid = PBField.initBytes(byteStringMicro);
        this.uint64_up_offset = PBField.initUInt64(0L);
        this.uint64_block_size = PBField.initUInt64(0L);
        this.bytes_encrypt_dstip = PBField.initBytes(byteStringMicro);
        this.uint32_roamdays = PBField.initUInt32(0);
        this.rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x352$IPv6Info.class);
        this.bytes_client_ip6 = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_down_para = PBField.initBytes(byteStringMicro);
        this.bytes_original_down_para = PBField.initBytes(byteStringMicro);
        this.bytes_down_domain = PBField.initBytes(byteStringMicro);
        this.bytes_big_down_para = PBField.initBytes(byteStringMicro);
        this.bytes_big_thumb_down_para = PBField.initBytes(byteStringMicro);
        this.uint32_https_url_flag = PBField.initUInt32(0);
        this.msg_info4busi = new MessageMicro<cmd0x352$TryUpInfo4Busi>() { // from class: tencent.im.cs.cmd0x352.cmd0x352$TryUpInfo4Busi
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_big_down_url;
            public final PBBytesField bytes_down_domain;
            public final PBBytesField bytes_file_resid;
            public final PBBytesField bytes_original_down_url;
            public final PBBytesField bytes_thumb_down_url;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bytes_file_resid", "bytes_down_domain", "bytes_thumb_down_url", "bytes_original_down_url", "bytes_big_down_url"}, new Object[]{byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2}, cmd0x352$TryUpInfo4Busi.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_file_resid = PBField.initBytes(byteStringMicro2);
                this.bytes_down_domain = PBField.initBytes(byteStringMicro2);
                this.bytes_thumb_down_url = PBField.initBytes(byteStringMicro2);
                this.bytes_original_down_url = PBField.initBytes(byteStringMicro2);
                this.bytes_big_down_url = PBField.initBytes(byteStringMicro2);
            }
        };
    }
}
