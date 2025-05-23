package tencent.im.cs.cmd0x388;

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
public final class cmd0x388$TryUpImgRsp extends MessageMicro<cmd0x388$TryUpImgRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exit;
    public final PBBoolField bool_new_big_chan;
    public final PBBytesField bytes_client_ip6;
    public final PBBytesField bytes_download_index;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_up_ukey;
    public cmd0x388$ImgInfo msg_img_info;
    public cmd0x388$TryUpInfo4Busi msg_info4busi;
    public final PBRepeatMessageField<cmd0x388$IPv6Info> rpt_msg_up_ip6;
    public final PBRepeatField<Integer> rpt_uint32_up_ip;
    public final PBRepeatField<Integer> rpt_uint32_up_port;
    public final PBUInt64Field uint64_block_size;
    public final PBUInt64Field uint64_fileid;
    public final PBUInt64Field uint64_up_offset;
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 88, 96, 210, 218, 226, 8010}, new String[]{"uint64_file_id", "uint32_result", "bytes_fail_msg", "bool_file_exit", "msg_img_info", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "uint64_fileid", "uint64_up_offset", "uint64_block_size", "bool_new_big_chan", "rpt_msg_up_ip6", "bytes_client_ip6", "bytes_download_index", "msg_info4busi"}, new Object[]{0L, 0, byteStringMicro, bool, null, 0, 0, byteStringMicro, 0L, 0L, 0L, bool, null, byteStringMicro, byteStringMicro, null}, cmd0x388$TryUpImgRsp.class);
    }

    public cmd0x388$TryUpImgRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.bool_file_exit = PBField.initBool(false);
        this.msg_img_info = new cmd0x388$ImgInfo();
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_up_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_up_port = PBField.initRepeat(pBUInt32Field);
        this.bytes_up_ukey = PBField.initBytes(byteStringMicro);
        this.uint64_fileid = PBField.initUInt64(0L);
        this.uint64_up_offset = PBField.initUInt64(0L);
        this.uint64_block_size = PBField.initUInt64(0L);
        this.bool_new_big_chan = PBField.initBool(false);
        this.rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x388$IPv6Info.class);
        this.bytes_client_ip6 = PBField.initBytes(byteStringMicro);
        this.bytes_download_index = PBField.initBytes(byteStringMicro);
        this.msg_info4busi = new cmd0x388$TryUpInfo4Busi();
    }
}
