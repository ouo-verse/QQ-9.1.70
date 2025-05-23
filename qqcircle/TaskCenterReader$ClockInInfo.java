package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$ClockInInfo extends MessageMicro<TaskCenterReader$ClockInInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField enabled = PBField.initBool(false);
    public final PBUInt32Field daysCount = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> texts = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> images = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField jumpURL = PBField.initString("");
    public final PBBoolField isLastDay = PBField.initBool(false);
    public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field pushTime = PBField.initInt64(0);
    public final PBBoolField isPush = PBField.initBool(false);

    static {
        String[] strArr = {NodeProps.ENABLED, "daysCount", "duration", "status", "texts", "images", "jumpURL", "isLastDay", "transInfo", "pushTime", "isPush"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 82, 88, 96}, strArr, new Object[]{bool, 0, 0, 0, null, null, "", bool, ByteStringMicro.EMPTY, 0L, bool}, TaskCenterReader$ClockInInfo.class);
    }
}
