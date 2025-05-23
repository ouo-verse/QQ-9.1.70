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
public final class cmd0x346$ApplyCopyToReq extends MessageMicro<cmd0x346$ApplyCopyToReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 320, 400, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 642}, new String[]{"uint64_dst_id", "uint64_dst_uin", "uint32_dst_svcid", "uint64_src_uin", "uint64_file_size", "str_file_name", "str_local_filepath", "bytes_uuid"}, new Object[]{0L, 0L, 0, 0L, 0L, "", "", ByteStringMicro.EMPTY}, cmd0x346$ApplyCopyToReq.class);
    public final PBUInt64Field uint64_dst_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_dst_svcid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
}
