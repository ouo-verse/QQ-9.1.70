package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$CooperatorUser extends MessageMicro<topic_info$CooperatorUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"str_head_url", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "latest_op_time", "uid"}, new Object[]{"", "", 0L, 0L}, topic_info$CooperatorUser.class);
    public final PBStringField str_head_url = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
    public final PBUInt64Field latest_op_time = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
