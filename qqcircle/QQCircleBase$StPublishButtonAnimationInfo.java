package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleBase$StPublishButtonAnimationInfo extends MessageMicro<QQCircleBase$StPublishButtonAnimationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90}, new String[]{"isShowAnimation", "hashIcon", "hashTag", "words", "backImg", "operatorIcon", WadlProxyConsts.KEY_JUMP_URL, "animationStartupTime", "animationShowTime", "reportExt", MiniAppGetGameTaskTicketServlet.KEY_TASKID}, new Object[]{0, "", "", "", "", "", "", 0L, 0L, "", ""}, QQCircleBase$StPublishButtonAnimationInfo.class);
    public final PBInt32Field isShowAnimation = PBField.initInt32(0);
    public final PBStringField hashIcon = PBField.initString("");
    public final PBStringField hashTag = PBField.initString("");
    public final PBStringField words = PBField.initString("");
    public final PBStringField backImg = PBField.initString("");
    public final PBStringField operatorIcon = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBInt64Field animationStartupTime = PBField.initInt64(0);
    public final PBInt64Field animationShowTime = PBField.initInt64(0);
    public final PBStringField reportExt = PBField.initString("");
    public final PBStringField taskId = PBField.initString("");
}
