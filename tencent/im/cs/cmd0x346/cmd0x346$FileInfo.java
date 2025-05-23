package tencent.im.cs.cmd0x346;

import com.tencent.luggage.wxa.ef.h;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$FileInfo extends MessageMicro<cmd0x346$FileInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5;
    public final PBBytesField bytes_3sha;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_sha;
    public final PBBytesField bytes_uuid;
    public final PBStringField str_file_name;
    public final PBStringField str_fileidcrc;
    public final PBUInt32Field uint32_abs_file_type;
    public final PBUInt32Field uint32_client_type;
    public final PBUInt32Field uint32_expire_time;
    public final PBUInt64Field uint64_owner_uin;
    public final PBUInt64Field uint64_peer_uin;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 720, 802, 810, x.CTRL_INDEX, 960, 968, 1040, 1122, BusinessInfoCheckUpdateItem.UIAPPID_KANDIAN, h.CTRL_INDEX}, new String[]{"uint64_uin", "uint32_danger_evel", "uint64_file_size", "uint32_life_time", "uint32_upload_time", "bytes_uuid", "str_file_name", "uint32_abs_file_type", "bytes_10m_md5", "bytes_sha", "uint32_client_type", "uint64_owner_uin", "uint64_peer_uin", "uint32_expire_time", "str_fileidcrc", "bytes_md5", "bytes_3sha"}, new Object[]{0L, 0, 0L, 0, 0, byteStringMicro, "", 0, byteStringMicro, byteStringMicro, 0, 0L, 0L, 0, "", byteStringMicro, byteStringMicro}, cmd0x346$FileInfo.class);
    }

    public cmd0x346$FileInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_uuid = PBField.initBytes(byteStringMicro);
        this.str_file_name = PBField.initString("");
        this.uint32_abs_file_type = PBField.initUInt32(0);
        this.bytes_10m_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_sha = PBField.initBytes(byteStringMicro);
        this.uint32_client_type = PBField.initUInt32(0);
        this.uint64_owner_uin = PBField.initUInt64(0L);
        this.uint64_peer_uin = PBField.initUInt64(0L);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.str_fileidcrc = PBField.initString("");
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_3sha = PBField.initBytes(byteStringMicro);
    }
}
