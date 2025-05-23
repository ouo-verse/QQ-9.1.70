package q72;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.b;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetDailyQuestionRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetUserTacitHistoryRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$SetMiniUserInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$SetUserTacitAnswerRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$UpdateUserTagsRsp;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements b {
    public void b(String str) {
        QLog.i("MatchFriendMiniInfoObserver", 1, "handleGetDailyQuestionFail msg=$msg");
    }

    public void i(String str) {
        QLog.i("MatchFriendMiniInfoObserver", 1, "handleGetUserTracitHistoryFail msg=$msg");
    }

    public void r(String str) {
        QLog.i("MatchFriendMiniInfoObserver", 1, "handleSetUserTracitAnswerFail msg=$msg");
    }

    public void s() {
        QLog.i("MatchFriendMiniInfoObserver", 1, "handleSetUserTracitAnswerSuccess");
    }

    public void a(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$GetDailyQuestionRsp userinfo_getdailyquestionrsp = new userInfo$GetDailyQuestionRsp();
            try {
                userinfo_getdailyquestionrsp.mergeFrom((byte[]) obj);
                if (userinfo_getdailyquestionrsp.ret_code.get() == 0) {
                    c(userinfo_getdailyquestionrsp);
                    return;
                } else {
                    b(userinfo_getdailyquestionrsp.err_msg.get());
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check handleGetDailyQuestion error: " + e16);
                return;
            }
        }
        b("\u83b7\u53d6\u9ed8\u5951\u95ee\u7b54\u5931\u8d25");
    }

    public void h(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$GetUserTacitHistoryRsp userinfo_getusertacithistoryrsp = new userInfo$GetUserTacitHistoryRsp();
            try {
                userinfo_getusertacithistoryrsp.mergeFrom((byte[]) obj);
                if (userinfo_getusertacithistoryrsp.ret_code.get() == 0) {
                    j(userinfo_getusertacithistoryrsp);
                    return;
                } else {
                    i(userinfo_getusertacithistoryrsp.err_msg.get());
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check handleGetUserTracitHistory error: " + e16);
                return;
            }
        }
        i("\u83b7\u53d6\u7528\u6237\u6211\u7684\u56de\u7b54");
    }

    public void n(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$SetMiniUserInfoRsp userinfo_setminiuserinforsp = new userInfo$SetMiniUserInfoRsp();
            try {
                userinfo_setminiuserinforsp.mergeFrom((byte[]) obj);
                if (userinfo_setminiuserinforsp.err_code.get() == 0) {
                    p(userinfo_setminiuserinforsp);
                    return;
                } else {
                    o(userinfo_setminiuserinforsp.err_msg.get());
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check miniUserInfoRsp error: " + e16);
                return;
            }
        }
        o("\u8bbe\u7f6e\u7528\u6237\u4fe1\u606f\u5931\u8d25");
    }

    public void q(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$SetUserTacitAnswerRsp userinfo_setusertacitanswerrsp = new userInfo$SetUserTacitAnswerRsp();
            try {
                userinfo_setusertacitanswerrsp.mergeFrom((byte[]) obj);
                if (userinfo_setusertacitanswerrsp.ret_code.get() == 0) {
                    s();
                    return;
                } else {
                    r(userinfo_setusertacitanswerrsp.err_msg.get());
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check handleSetUserTracitAnswer error: " + e16);
                return;
            }
        }
        r("\u8bbe\u7f6e\u9ed8\u5951\u95ee\u7b54\u5931\u8d25");
    }

    public void t(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$UpdateUserTagsRsp userinfo_updateusertagsrsp = new userInfo$UpdateUserTagsRsp();
            try {
                userinfo_updateusertagsrsp.mergeFrom((byte[]) obj);
                if (userinfo_updateusertagsrsp.ret_code.get() == 0) {
                    v();
                    return;
                } else {
                    u(userinfo_updateusertagsrsp.err_msg.get());
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check handleUpdateUserTag error: " + e16);
                return;
            }
        }
        u("\u66f4\u65b0\u7528\u6237\u5174\u8da3\u7b7e\u5931\u8d25");
    }

    public void e(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$GetMiniUserInfoRsp userinfo_getminiuserinforsp = new userInfo$GetMiniUserInfoRsp();
            try {
                userinfo_getminiuserinforsp.mergeFrom((byte[]) obj);
                if (userinfo_getminiuserinforsp.code.get() == 0) {
                    g(userinfo_getminiuserinforsp.infos.get());
                    return;
                } else {
                    f(null);
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check miniUserInfoRsp error: " + e16);
                return;
            }
        }
        f(null);
    }

    public void k(boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$GetMiniUserInfoRsp userinfo_getminiuserinforsp = new userInfo$GetMiniUserInfoRsp();
            try {
                userinfo_getminiuserinforsp.mergeFrom((byte[]) obj);
                if (userinfo_getminiuserinforsp.code.get() == 0) {
                    m(userinfo_getminiuserinforsp.infos.get());
                    return;
                } else {
                    l(null);
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendMiniInfoObserver", 1, "check miniUserInfoRsp error: " + e16);
                l(null);
                return;
            }
        }
        l(null);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 33) {
            switch (i3) {
                case 24:
                    e(z16, obj);
                    return;
                case 25:
                    n(z16, obj);
                    return;
                case 26:
                    t(z16, obj);
                    return;
                default:
                    switch (i3) {
                        case 35:
                            d(z16, obj);
                            return;
                        case 36:
                            q(z16, obj);
                            return;
                        case 37:
                            h(z16, obj);
                            return;
                        case 38:
                            a(z16, obj);
                            return;
                        default:
                            return;
                    }
            }
        }
        k(z16, obj);
    }

    public void v() {
    }

    public void c(userInfo$GetDailyQuestionRsp userinfo_getdailyquestionrsp) {
    }

    public void f(String str) {
    }

    public void g(userInfo$MiniInfo userinfo_miniinfo) {
    }

    public void j(userInfo$GetUserTacitHistoryRsp userinfo_getusertacithistoryrsp) {
    }

    public void l(String str) {
    }

    public void m(userInfo$MiniInfo userinfo_miniinfo) {
    }

    public void o(String str) {
    }

    public void p(userInfo$SetMiniUserInfoRsp userinfo_setminiuserinforsp) {
    }

    public void u(String str) {
    }

    public void d(boolean z16, Object obj) {
    }
}
