package cn.shrmus.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogQuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionPidIsNull() {
            addCriterion("question_pid is null");
            return (Criteria) this;
        }

        public Criteria andQuestionPidIsNotNull() {
            addCriterion("question_pid is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionPidEqualTo(Integer value) {
            addCriterion("question_pid =", value, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidNotEqualTo(Integer value) {
            addCriterion("question_pid <>", value, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidGreaterThan(Integer value) {
            addCriterion("question_pid >", value, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_pid >=", value, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidLessThan(Integer value) {
            addCriterion("question_pid <", value, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidLessThanOrEqualTo(Integer value) {
            addCriterion("question_pid <=", value, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidIn(List<Integer> values) {
            addCriterion("question_pid in", values, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidNotIn(List<Integer> values) {
            addCriterion("question_pid not in", values, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidBetween(Integer value1, Integer value2) {
            addCriterion("question_pid between", value1, value2, "questionPid");
            return (Criteria) this;
        }

        public Criteria andQuestionPidNotBetween(Integer value1, Integer value2) {
            addCriterion("question_pid not between", value1, value2, "questionPid");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIsNull() {
            addCriterion("user_id_author is null");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIsNotNull() {
            addCriterion("user_id_author is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorEqualTo(Integer value) {
            addCriterion("user_id_author =", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotEqualTo(Integer value) {
            addCriterion("user_id_author <>", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorGreaterThan(Integer value) {
            addCriterion("user_id_author >", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_author >=", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorLessThan(Integer value) {
            addCriterion("user_id_author <", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_author <=", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIn(List<Integer> values) {
            addCriterion("user_id_author in", values, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotIn(List<Integer> values) {
            addCriterion("user_id_author not in", values, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorBetween(Integer value1, Integer value2) {
            addCriterion("user_id_author between", value1, value2, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_author not between", value1, value2, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIsNull() {
            addCriterion("user_id_reply is null");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIsNotNull() {
            addCriterion("user_id_reply is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyEqualTo(Integer value) {
            addCriterion("user_id_reply =", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotEqualTo(Integer value) {
            addCriterion("user_id_reply <>", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyGreaterThan(Integer value) {
            addCriterion("user_id_reply >", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_reply >=", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyLessThan(Integer value) {
            addCriterion("user_id_reply <", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_reply <=", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIn(List<Integer> values) {
            addCriterion("user_id_reply in", values, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotIn(List<Integer> values) {
            addCriterion("user_id_reply not in", values, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyBetween(Integer value1, Integer value2) {
            addCriterion("user_id_reply between", value1, value2, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_reply not between", value1, value2, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIsNull() {
            addCriterion("question_title is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIsNotNull() {
            addCriterion("question_title is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleEqualTo(String value) {
            addCriterion("question_title =", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotEqualTo(String value) {
            addCriterion("question_title <>", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThan(String value) {
            addCriterion("question_title >", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("question_title >=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThan(String value) {
            addCriterion("question_title <", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThanOrEqualTo(String value) {
            addCriterion("question_title <=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLike(String value) {
            addCriterion("question_title like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotLike(String value) {
            addCriterion("question_title not like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIn(List<String> values) {
            addCriterion("question_title in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotIn(List<String> values) {
            addCriterion("question_title not in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleBetween(String value1, String value2) {
            addCriterion("question_title between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotBetween(String value1, String value2) {
            addCriterion("question_title not between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeIsNull() {
            addCriterion("question_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeIsNotNull() {
            addCriterion("question_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeEqualTo(Date value) {
            addCriterion("question_publish_time =", value, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeNotEqualTo(Date value) {
            addCriterion("question_publish_time <>", value, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeGreaterThan(Date value) {
            addCriterion("question_publish_time >", value, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("question_publish_time >=", value, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeLessThan(Date value) {
            addCriterion("question_publish_time <", value, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("question_publish_time <=", value, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeIn(List<Date> values) {
            addCriterion("question_publish_time in", values, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeNotIn(List<Date> values) {
            addCriterion("question_publish_time not in", values, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeBetween(Date value1, Date value2) {
            addCriterion("question_publish_time between", value1, value2, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("question_publish_time not between", value1, value2, "questionPublishTime");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralIsNull() {
            addCriterion("question_integral is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralIsNotNull() {
            addCriterion("question_integral is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralEqualTo(Integer value) {
            addCriterion("question_integral =", value, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralNotEqualTo(Integer value) {
            addCriterion("question_integral <>", value, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralGreaterThan(Integer value) {
            addCriterion("question_integral >", value, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_integral >=", value, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralLessThan(Integer value) {
            addCriterion("question_integral <", value, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("question_integral <=", value, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralIn(List<Integer> values) {
            addCriterion("question_integral in", values, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralNotIn(List<Integer> values) {
            addCriterion("question_integral not in", values, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralBetween(Integer value1, Integer value2) {
            addCriterion("question_integral between", value1, value2, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("question_integral not between", value1, value2, "questionIntegral");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedIsNull() {
            addCriterion("question_accpeted is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedIsNotNull() {
            addCriterion("question_accpeted is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedEqualTo(Integer value) {
            addCriterion("question_accpeted =", value, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedNotEqualTo(Integer value) {
            addCriterion("question_accpeted <>", value, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedGreaterThan(Integer value) {
            addCriterion("question_accpeted >", value, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_accpeted >=", value, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedLessThan(Integer value) {
            addCriterion("question_accpeted <", value, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedLessThanOrEqualTo(Integer value) {
            addCriterion("question_accpeted <=", value, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedIn(List<Integer> values) {
            addCriterion("question_accpeted in", values, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedNotIn(List<Integer> values) {
            addCriterion("question_accpeted not in", values, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedBetween(Integer value1, Integer value2) {
            addCriterion("question_accpeted between", value1, value2, "questionAccpeted");
            return (Criteria) this;
        }

        public Criteria andQuestionAccpetedNotBetween(Integer value1, Integer value2) {
            addCriterion("question_accpeted not between", value1, value2, "questionAccpeted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}