package tencent.im.nearfield_group;

import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_group$ReqGetGroupList extends MessageMicro<nearfield_group$ReqGetGroupList> {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_head", "msg_lbs_info", "uint64_group_code"}, new Object[]{null, null, 0L}, nearfield_group$ReqGetGroupList.class);
    public nearfield_group$BusiReqHead msg_head = new nearfield_group$BusiReqHead();
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
