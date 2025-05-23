package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ApplyUploadReq extends MessageMicro<cmd0x346$ApplyUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 320, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, 720}, new String[]{"uint64_sender_uin", "uint64_recver_uin", "uint32_file_type", "uint64_file_size", "str_file_name", "bytes_10m_md5", "str_local_filepath", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0, 0L, "", ByteStringMicro.EMPTY, "", 0, 0L}, cmd0x346$ApplyUploadReq.class);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
}
