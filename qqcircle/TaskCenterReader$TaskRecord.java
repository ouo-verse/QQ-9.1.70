package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$TaskRecord extends MessageMicro<TaskCenterReader$TaskRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 66, 72}, new String[]{"taskType", "title", "desc", "haveDone", "maxCnt", WadlProxyConsts.KEY_JUMP_URL, "taskDesc", "bottonDesc", "bottonJumpFlag"}, new Object[]{0, "", "", 0, 0, "", "", "", 0}, TaskCenterReader$TaskRecord.class);
    public final PBEnumField taskType = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field haveDone = PBField.initInt32(0);
    public final PBInt32Field maxCnt = PBField.initInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField taskDesc = PBField.initString("");
    public final PBStringField bottonDesc = PBField.initString("");
    public final PBInt32Field bottonJumpFlag = PBField.initInt32(0);
}
