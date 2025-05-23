package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$GetImgUrlRsp extends MessageMicro<cmd0x388$GetImgUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_down_para;
    public final PBBytesField bytes_big_thumb_down_para;
    public final PBBytesField bytes_client_ip6;
    public final PBBytesField bytes_down_domain;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_original_down_para;
    public final PBBytesField bytes_thumb_down_para;
    public cmd0x388$ImgInfo msg_img_info;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_big_down_url;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_original_down_url;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_thumb_down_url;
    public final PBRepeatMessageField<cmd0x388$IPv6Info> rpt_msg_down_ip6;
    public final PBRepeatField<Integer> rpt_uint32_down_ip;
    public final PBRepeatField<Integer> rpt_uint32_down_port;
    public final PBRepeatField<Integer> rpt_uint32_order_down_type;
    public final PBUInt32Field uint32_auto_down_type;
    public final PBUInt32Field uint32_https_url_flag;
    public final PBUInt32Field uint32_result;
    public final PBUInt64Field uint64_file_id;
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 120, 128, 136, 154, 160, 210, 218}, new String[]{"uint64_fileid", "bytes_file_md5", "uint32_result", "bytes_fail_msg", "msg_img_info", "rpt_bytes_thumb_down_url", "rpt_bytes_original_down_url", "rpt_bytes_big_down_url", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_down_domain", "bytes_thumb_down_para", "bytes_original_down_para", "bytes_big_down_para", "uint64_file_id", "uint32_auto_down_type", "rpt_uint32_order_down_type", "bytes_big_thumb_down_para", "uint32_https_url_flag", "rpt_msg_down_ip6", "bytes_client_ip6"}, new Object[]{0L, byteStringMicro, 0, byteStringMicro, null, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0, 0, byteStringMicro, 0, null, byteStringMicro}, cmd0x388$GetImgUrlRsp.class);
    }

    public cmd0x388$GetImgUrlRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_result = PBField.initUInt32(0);
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.msg_img_info = new cmd0x388$ImgInfo();
        PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
        this.rpt_bytes_thumb_down_url = PBField.initRepeat(pBBytesField);
        this.rpt_bytes_original_down_url = PBField.initRepeat(pBBytesField);
        this.rpt_bytes_big_down_url = PBField.initRepeat(pBBytesField);
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_down_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_down_port = PBField.initRepeat(pBUInt32Field);
        this.bytes_down_domain = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_down_para = PBField.initBytes(byteStringMicro);
        this.bytes_original_down_para = PBField.initBytes(byteStringMicro);
        this.bytes_big_down_para = PBField.initBytes(byteStringMicro);
        this.uint64_file_id = PBField.initUInt64(0L);
        this.uint32_auto_down_type = PBField.initUInt32(0);
        this.rpt_uint32_order_down_type = PBField.initRepeat(pBUInt32Field);
        this.bytes_big_thumb_down_para = PBField.initBytes(byteStringMicro);
        this.uint32_https_url_flag = PBField.initUInt32(0);
        this.rpt_msg_down_ip6 = PBField.initRepeatMessage(cmd0x388$IPv6Info.class);
        this.bytes_client_ip6 = PBField.initBytes(byteStringMicro);
    }
}
