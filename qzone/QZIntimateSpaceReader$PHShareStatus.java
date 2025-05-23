package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$PHShareStatus extends MessageMicro<QZIntimateSpaceReader$PHShareStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "status_pattern"}, new Object[]{0, null}, QZIntimateSpaceReader$PHShareStatus.class);
    public final PBEnumField share_type = PBField.initEnum(0);
    public QZIntimateSpaceReader$PHStatusPattern status_pattern = new QZIntimateSpaceReader$PHStatusPattern();
}
