package qqcircle;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$StCountMsgInfo extends MessageMicro<QQCircleCounterMsg$StCountMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48}, new String[]{"msgBiz", "msgOper", QQBrowserActivity.KEY_MSG_TYPE, "feed", "touin", "msgLogicControl"}, new Object[]{0, 0, 0, null, "", 0}, QQCircleCounterMsg$StCountMsgInfo.class);
    public final PBEnumField msgBiz = PBField.initEnum(0);
    public final PBEnumField msgOper = PBField.initEnum(0);
    public final PBEnumField msgType = PBField.initEnum(0);
    public QQCircleCounterMsg$StCountMsgFeed feed = new MessageMicro<QQCircleCounterMsg$StCountMsgFeed>() { // from class: qqcircle.QQCircleCounterMsg$StCountMsgFeed
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"feedId", "author", "createTs", "operTs", "operUin"}, new Object[]{"", "", 0L, 0L, ""}, QQCircleCounterMsg$StCountMsgFeed.class);
        public final PBStringField feedId = PBField.initString("");
        public final PBStringField author = PBField.initString("");
        public final PBInt64Field createTs = PBField.initInt64(0);
        public final PBInt64Field operTs = PBField.initInt64(0);
        public final PBStringField operUin = PBField.initString("");
    };
    public final PBStringField touin = PBField.initString("");
    public final PBEnumField msgLogicControl = PBField.initEnum(0);
}
