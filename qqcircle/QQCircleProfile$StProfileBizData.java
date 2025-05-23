package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StProfileBizData extends MessageMicro<QQCircleProfile$StProfileBizData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56, 64, 74, 82}, new String[]{"followText", "groupIDList", "bindGroupStatus", "interFollowList", "interFollowInfo", "bindGuildStatus", "updateSchoolNum", "hideSchool", "modifyLimitFields", "bind_groups"}, new Object[]{"", 0L, 0, 0L, null, 0, 0, 0, null, null}, QQCircleProfile$StProfileBizData.class);
    public final PBInt32Field bindGroupStatus;
    public final PBInt32Field bindGuildStatus;
    public final PBRepeatMessageField<QQCircleProfile$QQGroup> bind_groups;
    public final PBStringField followText = PBField.initString("");
    public final PBRepeatField<Long> groupIDList;
    public final PBInt32Field hideSchool;
    public QQCircleProfile$StInterFollowInfo interFollowInfo;
    public final PBRepeatField<Long> interFollowList;
    public final PBRepeatMessageField<QQCircleProfile$StModifyLimitItem> modifyLimitFields;
    public final PBInt32Field updateSchoolNum;

    /* JADX WARN: Type inference failed for: r0v4, types: [qqcircle.QQCircleProfile$StInterFollowInfo] */
    public QQCircleProfile$StProfileBizData() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.groupIDList = PBField.initRepeat(pBUInt64Field);
        this.bindGroupStatus = PBField.initInt32(0);
        this.interFollowList = PBField.initRepeat(pBUInt64Field);
        this.interFollowInfo = new MessageMicro<QQCircleProfile$StInterFollowInfo>() { // from class: qqcircle.QQCircleProfile$StInterFollowInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"nicks", "total"}, new Object[]{"", 0}, QQCircleProfile$StInterFollowInfo.class);
            public final PBRepeatField<String> nicks = PBField.initRepeat(PBStringField.__repeatHelper__);
            public final PBInt32Field total = PBField.initInt32(0);
        };
        this.bindGuildStatus = PBField.initInt32(0);
        this.updateSchoolNum = PBField.initInt32(0);
        this.hideSchool = PBField.initInt32(0);
        this.modifyLimitFields = PBField.initRepeatMessage(QQCircleProfile$StModifyLimitItem.class);
        this.bind_groups = PBField.initRepeatMessage(QQCircleProfile$QQGroup.class);
    }
}
